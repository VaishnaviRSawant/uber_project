package com.project.uberApp.uberApp.strategies;

import com.project.uberApp.uberApp.entities.RideRequest;

public interface RideFareCalculationStrategy {

    double  RIDE_FARE_MULTIPLIER = 10;
    double calculateFare(RideRequest rideRequest);


}
