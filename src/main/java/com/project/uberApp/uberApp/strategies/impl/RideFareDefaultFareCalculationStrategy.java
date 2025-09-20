package com.project.uberApp.uberApp.strategies.impl;

import com.project.uberApp.uberApp.dto.RideRequestDto;
import com.project.uberApp.uberApp.entities.RideRequest;
import com.project.uberApp.uberApp.services.DistanceService;
import com.project.uberApp.uberApp.strategies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
@RequiredArgsConstructor
public class RideFareDefaultFareCalculationStrategy implements RideFareCalculationStrategy {

    private final DistanceService distanceService;

    @Override
    public double calculatFare(RideRequest rideRequest) {
        try {
            double distance = distanceService.calculateDistance(
                    rideRequest.getPickUpLocation(),
                    rideRequest.getDropOffLocation()
            );

            // Add base fare + distance-based fare
            double baseFare = 40.0;
            double distanceFare = distance * RIDE_FARE_MULTIPLIER;

            return baseFare + distanceFare;

        } catch (Exception e) {
            throw new RuntimeException("Error calculating fare: " + e.getMessage());
        }
    }
}