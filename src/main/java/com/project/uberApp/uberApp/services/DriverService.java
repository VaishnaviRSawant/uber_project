package com.project.uberApp.uberApp.services;

import com.project.uberApp.uberApp.dto.DriverDto;
import com.project.uberApp.uberApp.dto.RideDto;
import com.project.uberApp.uberApp.dto.RiderDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


public interface DriverService {
    RideDto acceptRide(Long rideId);
    RideDto cancelRide(Long rideId);
    RideDto startRide(Long rideId);
    RideDto endRide(Long rideId);
    RiderDto rateRider(Long rideId);
    DriverDto getMyProfile();
    List<RideDto> getAllMyRides();
}
