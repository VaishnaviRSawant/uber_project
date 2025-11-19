package com.project.uberApp.uberApp.services;

import com.project.uberApp.uberApp.dto.DriverDto;
import com.project.uberApp.uberApp.dto.RiderDto;
import com.project.uberApp.uberApp.entities.Driver;
import com.project.uberApp.uberApp.entities.Ride;
import com.project.uberApp.uberApp.entities.Rider;

public interface RatingService {

    DriverDto rateDriver(Ride ride, Integer rating);
    RiderDto rateRider(Ride ride, Integer rating);

    void createNewRating(Ride ride);

}
