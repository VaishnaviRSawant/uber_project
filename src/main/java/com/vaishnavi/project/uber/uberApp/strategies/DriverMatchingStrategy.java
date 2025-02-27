package com.vaishnavi.project.uber.uberApp.strategies;

import com.vaishnavi.project.uber.uberApp.dto.RideRequestDto;
import com.vaishnavi.project.uber.uberApp.entities.Driver;
import com.vaishnavi.project.uber.uberApp.entities.RideRequest;

import java.util.List;

public interface DriverMatchingStrategy {

     List<Driver> findMatchingWithDriver(RideRequest rideRequest);
}
