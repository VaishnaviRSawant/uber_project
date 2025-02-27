package com.project.uberApp.uberApp.strategies;

import com.project.uberApp.uberApp.dto.RideRequestDto;
import com.project.uberApp.uberApp.entities.RideRequest;

public interface RideFareCalculationStrategy {

    double  RIDE_FARE_MULTIPLIER = 10;
    double calculatFare(RideRequest rideRequest);


}
