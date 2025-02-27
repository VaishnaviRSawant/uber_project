package com.vaishnavi.project.uber.uberApp.dto;

import com.vaishnavi.project.uber.uberApp.entities.Driver;
import com.vaishnavi.project.uber.uberApp.entities.Rider;
import com.vaishnavi.project.uber.uberApp.entities.enums.PaymentMethod;
import com.vaishnavi.project.uber.uberApp.entities.enums.RideStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Data

public class RideDto {


    private long id;
    private Point pickupLocation;
    private Point dropOfLocation;
    private LocalDateTime createdTime;

    private RiderDto rider;
    private DriverDto driver;
    private PaymentMethod paymentMethod;
    private RideStatus rideStatus;

    private String otp;

    private Double fare;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;

}
