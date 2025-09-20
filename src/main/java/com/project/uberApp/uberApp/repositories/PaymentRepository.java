package com.project.uberApp.uberApp.repositories;

import com.project.uberApp.uberApp.entities.Payment;
import com.project.uberApp.uberApp.entities.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findByRide(Ride ride);
}
