package com.project.uberApp.uberApp.strategies.impl;

import com.project.uberApp.uberApp.entities.Driver;
import com.project.uberApp.uberApp.entities.Payment;
import com.project.uberApp.uberApp.entities.Ride;
import com.project.uberApp.uberApp.entities.Rider;
import com.project.uberApp.uberApp.entities.enums.PaymentStatus;
import com.project.uberApp.uberApp.entities.enums.TransactionMethod;
import com.project.uberApp.uberApp.repositories.PaymentRepository;
import com.project.uberApp.uberApp.services.PaymentService;
import com.project.uberApp.uberApp.services.WalletService;
import com.project.uberApp.uberApp.strategies.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


//Rider has 232 , Driver had 500
//Ride cost is 100, commission = 30
//Rider -> 232 - 100 = 132
//Driver -> 500 +(100 - 30) = 570

@Service
@RequiredArgsConstructor
public class WalletPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    private final PaymentRepository paymentRepository;

    @Override
    @Transactional
    public void processPayment(Payment payment) {

        Driver driver = payment.getRide().getDriver();
        Rider rider = payment.getRide().getRider();

        walletService.deductMoneyFromWallet(rider.getUser(),
                payment.getAmount(),null,payment.getRide(), TransactionMethod.RIDE);

        double driversCut = payment.getAmount() *  (1-PLATFORM_COMMISSION);

        walletService.addMoneyToWallet(driver.getUser(),driversCut,null,payment.getRide(),TransactionMethod.RIDE);

        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);
    }
}
