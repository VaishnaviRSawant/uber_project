package com.project.uberApp.uberApp.strategies.impl;

import com.project.uberApp.uberApp.entities.Driver;
import com.project.uberApp.uberApp.entities.Payment;
import com.project.uberApp.uberApp.entities.Wallet;
import com.project.uberApp.uberApp.entities.enums.PaymentStatus;
import com.project.uberApp.uberApp.entities.enums.TransactionMethod;
import com.project.uberApp.uberApp.repositories.PaymentRepository;
import com.project.uberApp.uberApp.services.PaymentService;
import com.project.uberApp.uberApp.services.WalletService;
import com.project.uberApp.uberApp.strategies.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//rider -> 100
//driver -> 70deduct 30Rs from driver's wallet(30% commission)

@Service
@RequiredArgsConstructor
public class CashPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    private final PaymentRepository paymentRepository;

    @Override
    public void processPayment(Payment payment) {
        Driver driver = payment.getRide().getDriver();

        double platformCommission = payment.getAmount() * PLATFORM_COMMISSION;

        walletService.deductMoneyFromWallet(driver.getUser(), platformCommission,null,payment.getRide(), TransactionMethod.RIDE);

        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);
        
    }
}
