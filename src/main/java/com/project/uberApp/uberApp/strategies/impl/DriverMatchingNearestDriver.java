package com.project.uberApp.uberApp.strategies.impl;

import com.project.uberApp.uberApp.dto.RideRequestDto;
import com.project.uberApp.uberApp.entities.Driver;
import com.project.uberApp.uberApp.strategies.DriverMachingStrategy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverMatchingNearestDriver implements DriverMachingStrategy {

    @Override
    public List<Driver> findMatchingDriver(RideRequestDto rideRequestDto) {
        return List.of();
    }
}
