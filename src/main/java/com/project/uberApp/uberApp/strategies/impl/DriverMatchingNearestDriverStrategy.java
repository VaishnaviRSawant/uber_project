package com.project.uberApp.uberApp.strategies.impl;

import com.project.uberApp.uberApp.entities.Driver;
import com.project.uberApp.uberApp.entities.RideRequest;
import com.project.uberApp.uberApp.repositories.DriverRepository;
import com.project.uberApp.uberApp.strategies.DriverMatchingStrategy;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DriverMatchingNearestDriverStrategy implements DriverMatchingStrategy {

    private final DriverRepository driverRepository;

    @Override
    public List<Driver> findMatchingDriver(RideRequest rideRequest) {
        return driverRepository.findTenNearestDrivers(rideRequest.getPickUpLocation());
    }



}
