package com.project.uberApp.uberApp.strategies.impl;

import com.project.uberApp.uberApp.dto.RideRequestDto;
import com.project.uberApp.uberApp.entities.Driver;
import com.project.uberApp.uberApp.strategies.DriverMachingStrategy;

import java.util.List;

public class DriverMatchingHighestRateDriverStrategy implements DriverMachingStrategy {
    @Override
    public List<Driver> findMatchingDriver(RideRequestDto rideRequestDto) {
        return List.of();
    }
}
