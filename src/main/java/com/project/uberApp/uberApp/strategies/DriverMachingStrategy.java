package com.project.uberApp.uberApp.strategies;

import com.project.uberApp.uberApp.dto.RideRequestDto;
import com.project.uberApp.uberApp.entities.Driver;

import java.util.List;

public interface DriverMachingStrategy {

    List<Driver> findMatchingDriver(RideRequestDto rideRequestDto);
}
