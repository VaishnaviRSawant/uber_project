package com.project.uberApp.uberApp.strategies.impl;

import com.project.uberApp.uberApp.dto.RideRequestDto;
import com.project.uberApp.uberApp.entities.RideRequest;
import com.project.uberApp.uberApp.services.DistanceService;
import com.project.uberApp.uberApp.strategies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RideFareDefaultFareCalculationStrategy implements RideFareCalculationStrategy {

    private  final DistanceService distanceService;
    @Override
    public double calculatFare(RideRequest rideRequest) {
        double distance = distanceService.calculateDistance(rideRequest.getPickUpLocation(),
                rideRequest.getDropOffPoint());
        return  distance*RIDE_FARE_MULTIPLIER;
    }
}
