package com.vaishnavi.project.uber.uberApp.entities;

import com.vaishnavi.project.uber.uberApp.entities.enums.TransactionMethod;
import com.vaishnavi.project.uber.uberApp.entities.enums.TransactionType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
public class walletTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double amount;

    private TransactionType transactionType;

    private TransactionMethod transactionMethod;

    @OneToOne(fetch = FetchType.LAZY)
    private Ride ride;

    private String transactionId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Wallet wallet;

    @CreationTimestamp
    private LocalDateTime timeStamp;
}
