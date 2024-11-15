package dev.otthon.transfermoney.controllers;

import dev.otthon.transfermoney.exceptions.BaseApiException;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(BaseApiException.class)
    public ProblemDetail handleBaseApiException(BaseApiException e) {
        return e.toProblemDetail();
    }

}
