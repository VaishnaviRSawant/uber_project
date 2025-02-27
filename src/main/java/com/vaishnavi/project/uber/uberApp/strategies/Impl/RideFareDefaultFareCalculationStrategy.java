package com.vaishnavi.project.uber.uberApp.strategies.Impl;

import com.vaishnavi.project.uber.uberApp.dto.RideRequestDto;
import com.vaishnavi.project.uber.uberApp.entities.RideRequest;
import com.vaishnavi.project.uber.uberApp.services.DistanceService;
import com.vaishnavi.project.uber.uberApp.strategies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideFareDefaultFareCalculationStrategy implements RideFareCalculationStrategy {

    private  final DistanceService distanceService;

    @Override
    public double calculateFare(RideRequest rideRequest) {
     double distance = distanceService.calculateDistance(rideRequest.getPickupLocation(),
             rideRequest.getDropOfLocation());

        return distance*RIDE_FARE_MULTIPLIER;
    }
}
