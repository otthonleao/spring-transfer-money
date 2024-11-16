package dev.otthon.transfermoney.controllers;

import dev.otthon.transfermoney.dtos.TransferDTO;
import dev.otthon.transfermoney.entities.Transfer;
import dev.otthon.transfermoney.services.TransferService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

    @Autowired
    private TransferService transferService;

    public ResponseEntity<Transfer> transfer(@RequestBody @Valid TransferDTO transferDTO) {
        var result = transferService.transfer(transferDTO);
        return ResponseEntity.ok(result);
    }

}
