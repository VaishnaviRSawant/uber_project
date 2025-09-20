package com.project.uberApp.uberApp.dto;

import com.project.uberApp.uberApp.entities.Driver;
import com.project.uberApp.uberApp.entities.Rider;
import com.project.uberApp.uberApp.entities.enums.PaymentMethod;
import com.project.uberApp.uberApp.entities.enums.RideStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Data
public class RideDto {

    private Long id;
    private PointDto pickUpLocation;
    private PointDto dropOffLocation;
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
