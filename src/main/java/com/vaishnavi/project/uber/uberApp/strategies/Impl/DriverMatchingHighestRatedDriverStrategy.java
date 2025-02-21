package com.vaishnavi.project.uber.uberApp.strategies.Impl;

import com.vaishnavi.project.uber.uberApp.dto.RideRequestDto;
import com.vaishnavi.project.uber.uberApp.entities.Driver;
import com.vaishnavi.project.uber.uberApp.strategies.DriverMatchingStrategy;

import java.util.List;

public class DriverMatchingHighestRatedDriverStrategy implements DriverMatchingStrategy{
    @Override
    public List<Driver> findMatchingWithDrivers(RideRequestDto rideRequestDto) {
        return List.of();
    }
}
