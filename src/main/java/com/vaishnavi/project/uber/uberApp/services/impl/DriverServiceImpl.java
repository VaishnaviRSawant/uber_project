package com.vaishnavi.project.uber.uberApp.services.impl;

import com.vaishnavi.project.uber.uberApp.dto.DriverDto;
import com.vaishnavi.project.uber.uberApp.dto.RideDto;
import com.vaishnavi.project.uber.uberApp.dto.RideRequestDto;
import com.vaishnavi.project.uber.uberApp.dto.RiderDto;
import com.vaishnavi.project.uber.uberApp.services.DriverService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {
    @Override
    public RideRequestDto acceptRide(Long rideId) {
        return null;
    }

    @Override
    public RideDto cancelRide(Long rideId) {
        return null;
    }

    @Override
    public RideDto startRide(Long rideId) {
        return null;
    }

    @Override
    public RideDto endRide(Long rideId) {
        return null;
    }

    @Override
    public RiderDto rateRider(Long rideId, Integer rating) {
        return null;
    }

    @Override
    public DriverDto getMyProfile() {
        return null;
    }

    @Override
    public List<RideDto> geAllMyRides() {
        return List.of();
    }
}
