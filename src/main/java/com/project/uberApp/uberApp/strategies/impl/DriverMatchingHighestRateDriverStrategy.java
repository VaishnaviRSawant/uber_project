package com.project.uberApp.uberApp.strategies.impl;

import com.project.uberApp.uberApp.entities.Driver;
import com.project.uberApp.uberApp.entities.RideRequest;
import com.project.uberApp.uberApp.repositories.DriverRepository;
import com.project.uberApp.uberApp.strategies.DriverMatchingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DriverMatchingHighestRateDriverStrategy implements DriverMatchingStrategy {

    private  final DriverRepository driverRepository;


    @Override
    public List<Driver> findMatchingDriver(RideRequest rideRequest) {
        return driverRepository.findTenNearbyTopRatedDrivers(rideRequest.getPickUpLocation());
    }
}
