package com.project.uberApp.uberApp.services.impl;

import com.project.uberApp.uberApp.dto.DriverDto;
import com.project.uberApp.uberApp.dto.RideDto;
import com.project.uberApp.uberApp.dto.RideRequestDto;
import com.project.uberApp.uberApp.services.RiderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiderServiceImpl implements RiderService {
    @Override
    public RideRequestDto requestRide(RideRequestDto rideRequestDto) {
        return null;
    }

    @Override
    public RideDto cancelRide(Long rideId) {
        return null;
    }

    @Override
    public DriverDto rateRider(Long rideId, Integer rating) {

        return null;
    }

    @Override
    public RideDto getMyProfile() {

        return null;
    }

    @Override
    public List<RideDto> getAllMyRides() {

        return List.of();
    }
}
