package com.vaishnavi.project.uber.uberApp.entities;

import com.sun.jdi.PrimitiveValue;
import com.vaishnavi.project.uber.uberApp.entities.enums.PaymentMethod;
import com.vaishnavi.project.uber.uberApp.entities.enums.PaymentStatus;
import jakarta.persistence.*;
import org.apache.logging.log4j.util.Lazy;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @OneToOne(fetch = FetchType.LAZY)
    private Ride ride;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @CreationTimestamp
    private LocalDateTime paymentTime;



}
