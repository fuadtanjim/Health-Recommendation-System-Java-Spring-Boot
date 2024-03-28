package com.javamavericks.health_recommendation.exception;

import lombok.Getter;

public class AccountServiceException extends Exception{
    @Getter private String responseMessage;
    @Getter private int statusCode = 400;

    public AccountServiceException(String messageCode, String message) {
        super(messageCode);
        this.responseMessage = message;
    }

    public AccountServiceException(String messageCode, int statusCode, String message) {
        super(messageCode);
        this.responseMessage = message;
        this.statusCode = statusCode;
    }
}
