package com.vaishnavi.project.uber.uberApp.services;

import com.vaishnavi.project.uber.uberApp.dto.DriverDto;
import com.vaishnavi.project.uber.uberApp.dto.RideDto;
import com.vaishnavi.project.uber.uberApp.dto.RideRequestDto;
import com.vaishnavi.project.uber.uberApp.dto.RiderDto;
import com.vaishnavi.project.uber.uberApp.entities.Ride;

import java.util.List;

public interface DriverService {

    RideRequestDto acceptRide(Long rideId);

    RideDto cancelRide(Long rideId);

    RideDto startRide(Long rideId);

    RideDto endRide(Long rideId);

    RiderDto rateRider (Long rideId, Integer rating);

    DriverDto getMyProfile();

    List<RideDto> geAllMyRides();

}
