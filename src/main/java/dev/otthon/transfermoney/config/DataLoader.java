package dev.otthon.transfermoney.config;

import dev.otthon.transfermoney.entities.WalletType;
import dev.otthon.transfermoney.repositories.WalletRepository;
import dev.otthon.transfermoney.repositories.WalletTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {

    @Autowired
    private WalletTypeRepository walletTypeRepository;


    @Override
    public void run(String... args) throws Exception {
        Arrays.stream((WalletType.Enum.values()))
                .forEach(walletType -> walletTypeRepository.save(walletType.get()));
    }
}
