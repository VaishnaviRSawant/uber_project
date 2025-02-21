package com.project.uberApp.uberApp.dto;

import com.project.uberApp.uberApp.entities.Driver;
import com.project.uberApp.uberApp.entities.Rider;
import com.project.uberApp.uberApp.entities.enums.PaymentMethod;
import com.project.uberApp.uberApp.entities.enums.RideStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

public class RideDto {

    private Long id;
    private Point pickUpLocation;
    private Point dropOffPoint;
    private LocalDateTime createdTime;

    private RiderDto rider;
    private DriverDto driver;
    private PaymentMethod paymentMethod;
    private RideStatus rideStatus;

    private String otp;

    private Double fare;
    private  LocalDateTime startedAt;
    private  LocalDateTime endedAt;
}
