package com.vaishnavi.project.uber.uberApp.strategies;

import com.vaishnavi.project.uber.uberApp.dto.RideRequestDto;
import com.vaishnavi.project.uber.uberApp.entities.Ride;

public interface RideFareCalculationStrategy {

    double calculateFare(RideRequestDto rideRequestDto);
}
