package com.project.uberApp.uberApp.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private  User user;

    private Double balance;

    @OneToMany(mappedBy = "wallet",fetch = FetchType.LAZY)
    private List<WalletTransaction> transactionas;


}
