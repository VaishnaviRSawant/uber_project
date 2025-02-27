package com.vaishnavi.project.uber.uberApp.dto;


import com.vaishnavi.project.uber.uberApp.entities.Rider;
import com.vaishnavi.project.uber.uberApp.entities.enums.PaymentMethod;
import com.vaishnavi.project.uber.uberApp.entities.enums.RideRequestStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RideRequestDto {
    private long id;

    private PointDto pickupLocation;

    private PointDto dropOfLocation;

    private LocalDateTime requestedTime;

    private RiderDto rider;

    private PaymentMethod paymentMethod;

    private RideRequestStatus rideRequestStatus;

}
