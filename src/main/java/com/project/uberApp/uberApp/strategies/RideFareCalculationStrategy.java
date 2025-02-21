package com.project.uberApp.uberApp.strategies;

import com.project.uberApp.uberApp.dto.RideRequestDto;

public interface RideFareCalculationStrategy {
    double calculatFare(RideRequestDto rideRequestDto);


}
