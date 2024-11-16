package dev.otthon.transfermoney.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class TransferNotAllowedForWalletTypeException extends BaseApiException {

//    private final String walletType;
//
//    public TransferNotAllowedForWalletTypeException(String walletType) {
//        this.walletType = walletType;
//    }

    @Override
    public ProblemDetail toProblemDetail() {
        var problem = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        problem.setTitle("Transfer not allowed for wallet type");
        problem.setDetail("The transfer is not allowed for wallet type");
        return problem;
    }

}
