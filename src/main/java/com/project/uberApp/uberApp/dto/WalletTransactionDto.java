package com.project.uberApp.uberApp.dto;

import com.project.uberApp.uberApp.entities.Ride;
import com.project.uberApp.uberApp.entities.Wallet;
import com.project.uberApp.uberApp.entities.enums.TransactionMethod;
import com.project.uberApp.uberApp.entities.enums.TransactionType;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
public class WalletTransactionDto {
    private Long id;

    private double amount;

    private TransactionType transactionType;

    private TransactionMethod transactionMethod;

    private RideDto ride;

    private String transactionId;

    private WalletDto wallet;

    @CreationTimestamp
    private LocalDateTime timeStamp;
}
