package com.project.uberApp.uberApp.services;

import com.project.uberApp.uberApp.dto.WalletTransactionDto;
import com.project.uberApp.uberApp.entities.WalletTransaction;

public interface WalletTransactionService {

    void createNewWalletTransaction(WalletTransaction walletTransaction);
}
