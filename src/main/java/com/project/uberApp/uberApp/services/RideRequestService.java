package com.project.uberApp.uberApp.services;

import com.project.uberApp.uberApp.dto.RideRequestDto;
import com.project.uberApp.uberApp.entities.RideRequest;

public interface RideRequestService {

    RideRequest findRideRequestById(Long rideRequestId);

    void update(RideRequest rideRequest);

    RideRequest createRideRequest(RideRequestDto rideRequestDto);
}