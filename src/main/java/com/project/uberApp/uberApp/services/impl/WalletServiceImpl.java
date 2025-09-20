package com.project.uberApp.uberApp.services.impl;

import com.project.uberApp.uberApp.dto.RideDto;
import com.project.uberApp.uberApp.dto.WalletDto;
import com.project.uberApp.uberApp.dto.WalletTransactionDto;
import com.project.uberApp.uberApp.entities.Ride;
import com.project.uberApp.uberApp.entities.User;
import com.project.uberApp.uberApp.entities.Wallet;
import com.project.uberApp.uberApp.entities.WalletTransaction;
import com.project.uberApp.uberApp.entities.enums.TransactionMethod;
import com.project.uberApp.uberApp.entities.enums.TransactionType;
import com.project.uberApp.uberApp.exceptions.ResourceNotFoundException;
import com.project.uberApp.uberApp.repositories.WalletRepository;
import com.project.uberApp.uberApp.services.WalletService;
import com.project.uberApp.uberApp.services.WalletTransactionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {
    private final WalletRepository walletRepository;
    private final ModelMapper modelMapper;
    private final WalletTransactionService walletTransactionService;

    @Override
    @Transactional
    public Wallet addMoneyToWallet(User user, Double amount, String transactionId, Ride ride, TransactionMethod transactionMethod) {
       Wallet wallet = findByUser(user);
       wallet.setBalance(wallet.getBalance()+ amount);

        WalletTransaction walletTransaction = WalletTransaction.builder()
                .transactionId(transactionId)
                .ride(ride)
                .wallet(wallet)
                .transactionType(TransactionType.CREADIT)
                .transactionMethod(transactionMethod)
                .amount(amount)
                .build();


        walletTransactionService.createNewWalletTransaction(walletTransaction);

       return walletRepository.save(wallet);
    }

    @Override
    @Transactional
    public Wallet deductMoneyFromWallet(User user, Double amount, String transactionId,
                                        Ride ride, TransactionMethod transactionMethod) {
        Wallet wallet = findByUser(user);
        wallet.setBalance(wallet.getBalance()- amount);
        WalletTransaction walletTransaction = WalletTransaction.builder()
                .transactionId(transactionId)
                .ride(ride)
                .wallet(wallet)
                .transactionType(TransactionType.DEBIT)
                .transactionMethod(transactionMethod)
                .amount(amount)
                .build();

        //walletTransactionService.createNewWalletTransaction(walletTransaction);

        wallet.getTransactions().add(walletTransaction);

        return walletRepository.save(wallet);
    }

    @Override
    public void withdrawAllMoneyFromWallet() {


    }

    @Override
    public Wallet findWalletById(Long walletId) {
        return walletRepository.findById(walletId)
                .orElseThrow(() -> new  ResourceNotFoundException ("Wallet not found with id" + walletId));
    }

    @Override
    public Wallet createNewWallet(User user) {

        Wallet wallet= new Wallet();
        wallet.setUser(user);
        return walletRepository.save(wallet);
    }

    @Override
    public Wallet findByUser(User user) {
        return walletRepository.findByUser(user)
                .orElseThrow(() -> new ResourceNotFoundException("Wallet not fount for user with id:" + user.getId()));
    }
}
