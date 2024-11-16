package dev.otthon.transfermoney.services;

import dev.otthon.transfermoney.client.AuthorizationClient;
import dev.otthon.transfermoney.dtos.TransferDTO;
import dev.otthon.transfermoney.entities.Transfer;
import dev.otthon.transfermoney.exceptions.BaseApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    @Autowired
    private AuthorizationClient authorizationClient;

    public boolean isAuthorized(TransferDTO transferDTO) {
        var response = authorizationClient.isAuthorized();
        if (response.getStatusCode().isError()) {
            throw new BaseApiException();
        }
        return response.getBody().authorized();
    }

}
