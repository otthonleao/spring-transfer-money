package dev.otthon.transfermoney.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class DuplicateWalletException extends BaseApiException {

    private String detail;

    public DuplicateWalletException(String detail) {
        this.detail = detail;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.CONFLICT);
        problemDetail.setTitle("CONFLICT = Wallet data already exists");
        problemDetail.setDetail(detail);
        return problemDetail;
    }

}
