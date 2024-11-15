package dev.otthon.transfermoney.controllers;

import dev.otthon.transfermoney.dtos.CreateWalletDTO;
import dev.otthon.transfermoney.services.WalletService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @PostMapping("/wallet")
    public ResponseEntity<CreateWalletDTO> createWallet(@Valid @RequestBody CreateWalletDTO dto) {
        dto = walletService.createWallet(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }

}
