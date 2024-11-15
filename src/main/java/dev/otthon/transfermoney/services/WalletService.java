package dev.otthon.transfermoney.services;

import dev.otthon.transfermoney.dtos.CreateWalletDTO;
import dev.otthon.transfermoney.entities.Wallet;
import dev.otthon.transfermoney.exceptions.DuplicateWalletException;
import dev.otthon.transfermoney.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Transactional()
    public CreateWalletDTO createWallet(CreateWalletDTO dto) {

        var walletDb = walletRepository.findByCpfCnpjOrEmail(dto.getCpfCnpj(), dto.getEmail());

        if (walletDb.isPresent()) {
            throw new DuplicateWalletException("CPF/CNPJ or email already exists");
        }

        Wallet result = new Wallet();
        copyDtoToEntity(dto, result);
        result = walletRepository.save(result);
        return new CreateWalletDTO(result);
    }

    private void copyDtoToEntity(CreateWalletDTO dto, Wallet result) {
        result.setFullName(dto.getFullName());
        result.setCpfCnpj(dto.getCpfCnpj());
        result.setEmail(dto.getEmail());
        result.setPassword(dto.getPassword());
    }
}
