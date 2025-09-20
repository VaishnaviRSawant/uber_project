package com.project.uberApp.uberApp.services.impl;

import com.project.uberApp.uberApp.dto.DriverDto;
import com.project.uberApp.uberApp.dto.RideDto;
import com.project.uberApp.uberApp.dto.RideRequestDto;
import com.project.uberApp.uberApp.dto.RiderDto;
import com.project.uberApp.uberApp.entities.*;
import com.project.uberApp.uberApp.entities.enums.RideRequestStatus;
import com.project.uberApp.uberApp.entities.enums.RideStatus;
import com.project.uberApp.uberApp.exceptions.ResourceNotFoundException;
import com.project.uberApp.uberApp.repositories.RideRequestRepository;
import com.project.uberApp.uberApp.repositories.RiderRepository;
import com.project.uberApp.uberApp.services.DriverService;
import com.project.uberApp.uberApp.services.RideService;
import com.project.uberApp.uberApp.services.RiderService;
import com.project.uberApp.uberApp.strategies.RideFareCalculationStrategy;
import com.project.uberApp.uberApp.strategies.RideStrategyManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;

@Service
@RequiredArgsConstructor
@Slf4j
public class RiderServiceImpl implements RiderService {

    private final ModelMapper modelMapper;
    private final RideStrategyManager rideStrategyManager;
    private final RiderRepository riderRepository;
    private final RideRequestRepository rideRequestRepository;
    private final RideFareCalculationStrategy fareCalculationStrategy;
    private final RideService rideService;
    private final DriverService driverService;

    @Override
    @Transactional
    public RideRequestDto requestRide(RideRequestDto rideRequestDto) {
        Rider rider = getCurrentRider();

        if (rideRequestDto == null) {
            throw new IllegalArgumentException("Ride request cannot be null");
        }

        if (rideRequestDto.getPickUpLocation() == null || rideRequestDto.getDropOffLocation()== null) {
            throw new IllegalArgumentException("Pickup and drop-off locations cannot be null");
        }

        RideRequest rideRequest = modelMapper.map(rideRequestDto, RideRequest.class);
        rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);

        // Calculate fare safely
        Double fare = fareCalculationStrategy.calculatFare(rideRequest);
        rideRequest.setFare(fare);

        // Save the ride request
        RideRequest savedRideRequest = rideRequestRepository.save(rideRequest);

        // Find a matching driver safely
        if (rider.getRating() != null) {
            rideStrategyManager.driverMatchingStrategy(rider.getRating()).findMatchingDriver(rideRequest);
        } else {
            log.warn("Rider rating is null, skipping driver matching");
        }

        return modelMapper.map(savedRideRequest, RideRequestDto.class);
    }

    @Override
    public RideDto cancelRide(Long rideId) {
      Rider rider = getCurrentRider();
        Ride ride= rideService.getRideById(rideId);

        if (!rider.equals(ride.getRider())) {
            throw new RuntimeException("Rider does not own this ride with id:" + rideId);

        }
        if (!ride.getRideStatus().equals(RideStatus.CONFIRMED)) {
            throw new RuntimeException("Ride cannot be cancelled, invalid status: " + ride.getRideStatus());
        }

        Ride savedRide = rideService.updateRideStatus(ride, RideStatus.CANCELLED);
        driverService.updateDriverAvailability(ride.getDriver(), true);

        return modelMapper.map(savedRide, RideDto.class);

    }

    @Override
    public DriverDto rateRider(Long rideId, Integer rating) {
        if (rideId == null || rating == null) {
            throw new IllegalArgumentException("Ride ID and rating cannot be null");
        }
        // Implementation logic for rating a rider goes here...
        return null;
    }

    @Override
    public RiderDto getMyProfile() {
        Rider currentRider = getCurrentRider();
        return modelMapper.map(currentRider, RiderDto.class);
    }


    @Override
    public Page<RideDto> getAllMyRides(PageRequest pageRequest) {
      Rider currentRider = getCurrentRider();
        return rideService.getAllRidesOfRider(currentRider, pageRequest)
                .map(ride -> modelMapper.map(ride, RideDto.class)
                );
    }

    @Override
    public Rider createNewRider(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        Rider rider = Rider.builder()
                .user(user)
                .rating(0.0)
                .build();

        return riderRepository.save(rider);
    }

    @Override
    public Rider getCurrentRider() {
        return riderRepository.findById(1L)
                .orElseThrow(() -> new ResourceNotFoundException("Rider not found with id: 1"));
    }
}
