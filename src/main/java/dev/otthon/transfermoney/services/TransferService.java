package dev.otthon.transfermoney.services;

import dev.otthon.transfermoney.dtos.TransferDTO;
import dev.otthon.transfermoney.entities.Transfer;
import dev.otthon.transfermoney.entities.Wallet;
import dev.otthon.transfermoney.exceptions.InsufficientBalanceException;
import dev.otthon.transfermoney.exceptions.TransferNotAllowedForWalletTypeException;
import dev.otthon.transfermoney.exceptions.TransferNotAuthorizedException;
import dev.otthon.transfermoney.exceptions.WalletNotFoundException;
import dev.otthon.transfermoney.repositories.TransferRepository;
import dev.otthon.transfermoney.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CompletableFuture;

@Service
public class TransferService {

    @Autowired
    private AuthorizationService authorizationService;
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private WalletRepository walletRepository;
    @Autowired
    private TransferRepository transferRepository;

    @Transactional
    public Transfer transfer(TransferDTO transferDTO) {
        var sender =  walletRepository.findById(transferDTO.payer())
                .orElseThrow(() -> new WalletNotFoundException(transferDTO.payer()));

        var receiver =  walletRepository.findById(transferDTO.payee())
                .orElseThrow(() -> new WalletNotFoundException(transferDTO.payee()));

        validateTransfer(transferDTO, sender);

        sender.debit(transferDTO.value());
        sender.credit(transferDTO.value());

        var transfer = new Transfer(sender, receiver, transferDTO.value());
        walletRepository.save(sender);
        walletRepository.save(receiver);
        var transferResult = transferRepository.save(transfer);

        CompletableFuture.runAsync(() -> notificationService.sendNotification(transferResult));

        return transferResult;
    }

    private void validateTransfer(TransferDTO transferDTO, Wallet sender) {
        if (!sender.isTransferAllowedForWalletType()) {
            throw new TransferNotAllowedForWalletTypeException();
        }

        if (!sender.isBalancerEqualOrGreaterThan(transferDTO.value())) {
            throw new InsufficientBalanceException();
        }

        if (!authorizationService.isAuthorized(transferDTO)) {
            throw new TransferNotAuthorizedException();
        }
    }

}
