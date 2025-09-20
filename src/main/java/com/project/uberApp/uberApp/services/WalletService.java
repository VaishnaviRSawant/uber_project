package com.project.uberApp.uberApp.services;

import com.project.uberApp.uberApp.entities.Ride;
import com.project.uberApp.uberApp.entities.User;
import com.project.uberApp.uberApp.entities.Wallet;
import com.project.uberApp.uberApp.entities.enums.TransactionMethod;

public interface WalletService {

    Wallet addMoneyToWallet(User user, Double amount, String transactionId,
                            Ride ride, TransactionMethod transactionMethod);

    Wallet deductMoneyFromWallet(User user, Double amount, String transactionId,
                                 Ride ride, TransactionMethod transactionMethod);

    void withdrawAllMoneyFromWallet();

    Wallet findWalletById(Long walletId);

    Wallet createNewWallet(User user);

    Wallet findByUser(User user);

}
