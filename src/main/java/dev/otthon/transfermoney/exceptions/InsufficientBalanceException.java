package dev.otthon.transfermoney.exceptions;

import org.springframework.http.ProblemDetail;

public class InsufficientBalanceException extends BaseApiException {

    @Override
    public ProblemDetail toProblemDetail() {
        var problem = ProblemDetail.forStatus(422);
        problem.setTitle("Insufficient balance");
        problem.setDetail("The payer has insufficient balance to make the transfer. You cannot transfer a value bigger then your current balance.");
        return problem;
    }
}
