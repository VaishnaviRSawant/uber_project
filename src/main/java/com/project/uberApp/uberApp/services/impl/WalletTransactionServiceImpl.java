package com.project.uberApp.uberApp.services.impl;

import com.project.uberApp.uberApp.dto.WalletTransactionDto;
import com.project.uberApp.uberApp.entities.WalletTransaction;
import com.project.uberApp.uberApp.repositories.WalletTransactionRepository;
import com.project.uberApp.uberApp.services.WalletTransactionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletTransactionServiceImpl implements WalletTransactionService {

    private final WalletTransactionRepository walletTransactionRepository;
    private final ModelMapper modelMapper;

    @Override
    public void createNewWalletTransaction(WalletTransaction walletTransaction) {
           walletTransactionRepository.save(walletTransaction);
    }

}
