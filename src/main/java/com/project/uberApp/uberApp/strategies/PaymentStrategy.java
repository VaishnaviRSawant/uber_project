package com.project.uberApp.uberApp.strategies;

import com.project.uberApp.uberApp.entities.Payment;

public interface PaymentStrategy {

    static final Double PLATFORM_COMMISSION = 0.3;

    void processPayment(Payment payment);
}
