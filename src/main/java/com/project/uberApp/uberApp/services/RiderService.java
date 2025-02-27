package com.project.uberApp.uberApp.services;

import com.project.uberApp.uberApp.dto.DriverDto;
import com.project.uberApp.uberApp.dto.RideDto;
import com.project.uberApp.uberApp.dto.RideRequestDto;
import com.project.uberApp.uberApp.dto.RiderDto;
import com.project.uberApp.uberApp.entities.Rider;
import com.project.uberApp.uberApp.entities.User;

import java.util.List;

public interface RiderService {
    RideRequestDto requestRide(RideRequestDto rideRequestDto);

    RideDto cancelRide(Long rideId);

    DriverDto rateRider(Long rideId,Integer rating);

    RideDto getMyProfile();

    List<RideDto> getAllMyRides();

    Rider createNewRider(User user);

}
