package com.project.uberApp.uberApp.strategies.impl;

import com.project.uberApp.uberApp.entities.RideRequest;
import com.project.uberApp.uberApp.strategies.RideFareCalculationStrategy;
import org.springframework.stereotype.Service;

@Service
public class RideFareSurgePricingFareCalculationStrategy implements RideFareCalculationStrategy {
    @Override
    public double calculateFare(RideRequest rideRequest) {

        return 0;
    }
}
