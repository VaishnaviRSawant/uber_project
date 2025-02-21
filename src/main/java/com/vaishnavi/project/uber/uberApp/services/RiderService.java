package com.vaishnavi.project.uber.uberApp.services;

import com.vaishnavi.project.uber.uberApp.dto.DriverDto;
import com.vaishnavi.project.uber.uberApp.dto.RideDto;
import com.vaishnavi.project.uber.uberApp.dto.RideRequestDto;
import com.vaishnavi.project.uber.uberApp.dto.RiderDto;
import com.vaishnavi.project.uber.uberApp.entities.RideRequest;

import java.util.List;

public interface RiderService {

    RideRequestDto requestRide(RideRequestDto rideRequestDto);

    RideDto cancelRide(Long rideId);


    DriverDto rateRider (Long rideId, Integer rating);

    RiderDto getMyProfile();

    List<RideDto> geAllMyRides();

}
