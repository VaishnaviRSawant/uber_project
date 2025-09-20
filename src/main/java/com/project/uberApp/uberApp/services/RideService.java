package com.project.uberApp.uberApp.services;

import com.project.uberApp.uberApp.entities.Driver;
import com.project.uberApp.uberApp.entities.Ride;
import com.project.uberApp.uberApp.entities.RideRequest;
import com.project.uberApp.uberApp.entities.Rider;
import com.project.uberApp.uberApp.entities.enums.RideStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RideService {
    Ride getRideById(Long rideId);

    Ride createNewRide(RideRequest rideRequest, Driver driver);

    Ride updateRideStatus(Ride ride, RideStatus rideStatus);

    Page<Ride> getAllRidesOfRider(Rider rider, PageRequest pageRequest);

    Page<Ride> getAllRidesOfDriver(Driver driver, PageRequest pageRequest);
}
