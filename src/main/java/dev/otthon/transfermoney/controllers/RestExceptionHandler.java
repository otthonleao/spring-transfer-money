package dev.otthon.transfermoney.controllers;

import dev.otthon.transfermoney.exceptions.BaseApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.security.InvalidParameterException;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(BaseApiException.class)
    public ProblemDetail handleBaseApiException(BaseApiException e) {
        return e.toProblemDetail();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        var fieldErrors = e.getFieldErrors()
                .stream()
                .map(f -> new InvalidParam(f.getField(), f.getDefaultMessage()))
                .toList();

        var problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problemDetail.setTitle("Your request parameters didn't pass the validation");
        problemDetail.setProperty("invalid-paras", fieldErrors);
//        problemDetail.setDetail(e.getMessage());
        return problemDetail;
    }

    private record InvalidParam(String field, String message) {
    }

}
