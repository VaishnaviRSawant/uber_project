package com.project.uberApp.uberApp.strategies.impl;

import com.project.uberApp.uberApp.dto.RideRequestDto;
import com.project.uberApp.uberApp.strategies.RideFareCalculationStrategy;

public class RideFareDefaultFareCalculationStrategy implements RideFareCalculationStrategy {
    @Override
    public double calculatFare(RideRequestDto rideRequestDto) {
        return 0;
    }
}
