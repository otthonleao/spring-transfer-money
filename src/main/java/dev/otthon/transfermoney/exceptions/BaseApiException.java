package dev.otthon.transfermoney.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class BaseApiException extends RuntimeException {

    public ProblemDetail toProblemDetail() {

        var problemDetail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        problemDetail.setTitle("Bank Internal Server Error");
        return problemDetail;

    }
}
