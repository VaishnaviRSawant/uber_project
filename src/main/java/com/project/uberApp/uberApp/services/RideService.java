package com.project.uberApp.uberApp.services;

import com.project.uberApp.uberApp.dto.DriverDto;
import com.project.uberApp.uberApp.dto.RideDto;
import com.project.uberApp.uberApp.dto.RideRequestDto;
import com.project.uberApp.uberApp.dto.RiderDto;
import com.project.uberApp.uberApp.entities.Driver;
import com.project.uberApp.uberApp.entities.Ride;
import com.project.uberApp.uberApp.entities.enums.RideStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface RideService {
    Ride getRideById(Long RideId);

    void matchWithDrivers(RideRequestDto rideRequestDto);

    Ride createNewRide(RideRequestDto rideRequestDto, Driver driver);

    Ride updateRideStatus(Long rideId, RideStatus rideStatus);

    Page<Ride> getAllRidesOfRider(Long riderId, PageRequest pageRequest);

    Page<Ride> getAllRidesOfDriver(Long driverId, PageRequest pageRequest);
}
