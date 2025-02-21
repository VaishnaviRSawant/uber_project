package com.vaishnavi.project.uber.uberApp.entities;

import com.vaishnavi.project.uber.uberApp.entities.enums.PaymentMethod;
import com.vaishnavi.project.uber.uberApp.entities.enums.RideRequestStatus;
import com.vaishnavi.project.uber.uberApp.entities.enums.RideStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "Geometry(Point, 4326)") //for coordinate /location's latitude&longitude
    private Point pickupLocation;
    @Column(columnDefinition = "Geometry(Point, 4326)")
    private Point dropOfLocation;

    @CreationTimestamp
    private LocalDateTime createdTime;

    @ManyToOne(fetch =FetchType.LAZY )
    private Rider rider;

    @ManyToOne(fetch =FetchType.LAZY )
    private Driver driver;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    private RideStatus rideStatus;

    private String otp;

    private Double fare;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;

}
