package com.project.uberApp.uberApp.strategies.impl;

import com.project.uberApp.uberApp.entities.Driver;
import com.project.uberApp.uberApp.entities.RideRequest;
import com.project.uberApp.uberApp.strategies.DriverMatchingStrategy;

import java.util.List;

public class DriverMatchingHighestRateDriverStrategy implements DriverMatchingStrategy {
    @Override
    public List<Driver> findMatchingDriver(RideRequest rideRequest) {
        return List.of();
    }
}
