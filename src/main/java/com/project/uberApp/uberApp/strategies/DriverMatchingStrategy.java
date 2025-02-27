package com.project.uberApp.uberApp.strategies;

import com.project.uberApp.uberApp.entities.Driver;
import com.project.uberApp.uberApp.entities.RideRequest;

import java.util.List;

public interface DriverMatchingStrategy {

    List<Driver> findMatchingDriver(RideRequest rideRequest);
}
