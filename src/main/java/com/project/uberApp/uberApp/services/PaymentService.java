package com.project.uberApp.uberApp.services;

import com.project.uberApp.uberApp.entities.Payment;
import com.project.uberApp.uberApp.entities.Ride;
import com.project.uberApp.uberApp.entities.enums.PaymentStatus;

public interface PaymentService {

    void processPayment(Ride ride);

    Payment createNewPayment(Ride ride);

    void updatePaymentStatus(Payment payment, PaymentStatus status);
}
