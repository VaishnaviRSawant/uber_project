package com.project.uberApp.uberApp.services.impl;

import com.project.uberApp.uberApp.dto.RideRequestDto;
import com.project.uberApp.uberApp.entities.Driver;
import com.project.uberApp.uberApp.entities.Ride;
import com.project.uberApp.uberApp.entities.RideRequest;
import com.project.uberApp.uberApp.entities.Rider;
import com.project.uberApp.uberApp.entities.enums.RideRequestStatus;
import com.project.uberApp.uberApp.entities.enums.RideStatus;
import com.project.uberApp.uberApp.repositories.RideRepository;
import com.project.uberApp.uberApp.services.RideService;
import com.project.uberApp.uberApp.services.RideRequestService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class RideServiceImpl implements RideService {

    private final RideRepository rideRepository;
    private final RideRequestService rideRequestService;
    private final ModelMapper modelMapper;

    @Override
    public Ride getRideById(Long rideId) {
        return rideRepository.findById(rideId).orElse(null);
    }


    @Override
    public Ride createNewRide(RideRequest rideRequest, Driver driver) {
       rideRequest.setRideRequestStatus(RideRequestStatus.CONFIRMED);

         Ride ride = modelMapper.map(rideRequest, Ride.class);
         ride.setRideStatus(RideStatus.CONFIRMED);
         ride.setDriver(driver);
         ride.setOtp(generateRandomOTP());
         ride.setId(null);

         rideRequestService.update(rideRequest);
         return rideRepository.save(ride);
    }

    @Override
    public Ride updateRideStatus(Ride ride, RideStatus rideStatus) {
        ride.setRideStatus(rideStatus);
        return rideRepository.save(ride);
    }

    @Override
    public Page<Ride> getAllRidesOfRider(Rider rider, PageRequest pageRequest) {
        return rideRepository.findByRider(rider, pageRequest);
    }

    @Override
    public Page<Ride> getAllRidesOfDriver(Driver driver, PageRequest pageRequest) {
        return rideRepository.findByDriver(driver, pageRequest);
    }

    private String generateRandomOTP(){

        Random random = new Random();
        int otpInt = random.nextInt(10000); //0 to 9999
        return String.format("%04d",otpInt);

    }
}
