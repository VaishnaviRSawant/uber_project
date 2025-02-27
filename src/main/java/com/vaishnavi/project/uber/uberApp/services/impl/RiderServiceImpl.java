package com.vaishnavi.project.uber.uberApp.services.impl;

import com.vaishnavi.project.uber.uberApp.dto.DriverDto;
import com.vaishnavi.project.uber.uberApp.dto.RideDto;
import com.vaishnavi.project.uber.uberApp.dto.RideRequestDto;
import com.vaishnavi.project.uber.uberApp.dto.RiderDto;
import com.vaishnavi.project.uber.uberApp.entities.RideRequest;
import com.vaishnavi.project.uber.uberApp.entities.Rider;
import com.vaishnavi.project.uber.uberApp.entities.User;
import com.vaishnavi.project.uber.uberApp.entities.enums.RideRequestStatus;
import com.vaishnavi.project.uber.uberApp.repositories.RideRequestRepository;
import com.vaishnavi.project.uber.uberApp.repositories.RiderRepository;
import com.vaishnavi.project.uber.uberApp.services.RiderService;
import com.vaishnavi.project.uber.uberApp.strategies.DriverMatchingStrategy;
import com.vaishnavi.project.uber.uberApp.strategies.RideFareCalculationStrategy;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Builder
public class RiderServiceImpl implements RiderService {

    private final ModelMapper modelMapper;
    private final RideFareCalculationStrategy rideFareCalculationStrategy;
    private  final DriverMatchingStrategy driverMatchingStrategy;
    private final RideRequestRepository rideRequestRepository;
    private final RiderRepository riderRepository;

    @Override
    public RideRequestDto requestRide(RideRequestDto rideRequestDto) {
        RideRequest rideRequest = modelMapper.map(rideRequestDto, RideRequest.class);

       rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);

        double fare = rideFareCalculationStrategy.calculateFare(rideRequest);
        rideRequest.setFare(fare);

        RideRequest savedRideRequest = rideRequestRepository.save(rideRequest);

        driverMatchingStrategy.findMatchingWithDriver(rideRequest);

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
    public RiderDto getMyProfile() {
        return null;
    }

    @Override
    public List<RideDto> geAllMyRides() {
        return List.of();
    }

    @Override
    public Rider createNewRider(User user){
        Rider rider = Rider
                .builder()
                .user(user)
                .rating(0.0)
                .build();

        return riderRepository.save(rider);
    }
}
