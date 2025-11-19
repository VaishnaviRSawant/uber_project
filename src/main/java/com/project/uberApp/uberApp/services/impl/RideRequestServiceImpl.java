package com.project.uberApp.uberApp.services.impl;

import com.project.uberApp.uberApp.dto.RideRequestDto;
import com.project.uberApp.uberApp.entities.RideRequest;
import com.project.uberApp.uberApp.entities.Rider;
import com.project.uberApp.uberApp.exceptions.ResourceNotFoundException;
import com.project.uberApp.uberApp.repositories.RideRequestRepository;
import com.project.uberApp.uberApp.repositories.RiderRepository;
import com.project.uberApp.uberApp.services.RideRequestService;
import com.project.uberApp.uberApp.strategies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideRequestServiceImpl implements RideRequestService {

    private final RideRequestRepository rideRequestRepository;
    private final RiderRepository riderRepository;
    private final RideFareCalculationStrategy fareCalculationStrategy;
    private final GeometryFactory geometryFactory = new GeometryFactory();

    @Override
    public RideRequest findRideRequestById(Long rideRequestId) {
        return rideRequestRepository.findById(rideRequestId)
                .orElseThrow(() -> new ResourceNotFoundException("RideRequest not found with id: " + rideRequestId));
    }

    @Override
    public void update(RideRequest rideRequest) {
        rideRequestRepository.findById(rideRequest.getId())
                .orElseThrow(() -> new ResourceNotFoundException("RideRequest not found with id: " + rideRequest.getId()));
        rideRequestRepository.save(rideRequest);
    }

    // ADD THIS METHOD - Creates a new ride request with fare calculation
    @Override
    public RideRequest createRideRequest(RideRequestDto rideRequestDto) {
        // Convert DTO to Entity
        RideRequest rideRequest = new RideRequest();

        // Set locations
        rideRequest.setPickUpLocation(convertToPoint(rideRequestDto.getPickUpLocation()));
        rideRequest.setDropOffLocation(convertToPoint(rideRequestDto.getDropOffLocation()));

        // Set rider
        Rider rider = riderRepository.findById(rideRequestDto.getRider().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Rider not found with id: " + rideRequestDto.getRider().getId()));
        rideRequest.setRider(rider);

        // Set payment method and status
        rideRequest.setPaymentMethod(rideRequestDto.getPaymentMethod());
        rideRequest.setRideRequestStatus(rideRequestDto.getRideRequestStatus());

        // CALCULATE AND SET FARE - This is what you're missing!
        double fare = fareCalculationStrategy.calculateFare(rideRequest);
        rideRequest.setFare(fare);

        // Save and return
        return rideRequestRepository.save(rideRequest);
    }

    // Helper method to convert PointDto to Point
    private Point convertToPoint(com.project.uberApp.uberApp.dto.PointDto pointDto) {
        if (pointDto == null || pointDto.getCoordinates() == null || pointDto.getCoordinates().length < 2) {
            throw new IllegalArgumentException("Invalid point data");
        }

        return geometryFactory.createPoint(
                new Coordinate(pointDto.getCoordinates()[0], pointDto.getCoordinates()[1])
        );
    }
}