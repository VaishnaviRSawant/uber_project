package com.project.uberApp.uberApp.services.impl;

import com.project.uberApp.uberApp.dto.DriverDto;
import com.project.uberApp.uberApp.dto.RideDto;
import com.project.uberApp.uberApp.dto.RideRequestDto;
import com.project.uberApp.uberApp.entities.Ride;
import com.project.uberApp.uberApp.entities.RideRequest;
import com.project.uberApp.uberApp.entities.Rider;
import com.project.uberApp.uberApp.entities.User;
import com.project.uberApp.uberApp.entities.enums.RideRequestStatus;
import com.project.uberApp.uberApp.repositories.RideRequestRepository;
import com.project.uberApp.uberApp.repositories.RiderRepository;
import com.project.uberApp.uberApp.services.RiderService;
import com.project.uberApp.uberApp.strategies.DriverMatchingStrategy;
import com.project.uberApp.uberApp.strategies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RiderServiceImpl implements RiderService {

    private  final ModelMapper modelMapper;
    private  final RideFareCalculationStrategy rideFareCalculationStrategy;
    private  final DriverMatchingStrategy driverMatchingStrategy;
    private  final RiderRepository riderRepository;
    private  final RideRequestRepository rideRequestRepository;
    @Override
    public RideRequestDto requestRide(RideRequestDto rideRequestDto) {
        RideRequest rideRequest = modelMapper.map(rideRequestDto, RideRequest.class);

        rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);

        Double fare = rideFareCalculationStrategy.calculatFare(rideRequest);
        rideRequest.setFare(fare);

        RideRequest savedRideRequest = rideRequestRepository.save(rideRequest);

        driverMatchingStrategy.findMatchingDriver(rideRequest);

        return modelMapper.map(savedRideRequest, RideRequestDto.class);
    }

    @Override
    public RideDto cancelRide(Long rideId) {
        return null;
    }

    @Override
    public DriverDto rateRider(Long rideId, Integer rating) {

        return null;
    }

    @Override
    public RideDto getMyProfile() {

        return null;
    }

    @Override
    public List<RideDto> getAllMyRides() {

        return List.of();
    }

    @Override
    public Rider createNewRider(User user){
        Rider rider = Rider
                .builder().user(user)
                .user(user)
                .rating(0.0)
                .build();
        return riderRepository.save(rider);
    }
}
