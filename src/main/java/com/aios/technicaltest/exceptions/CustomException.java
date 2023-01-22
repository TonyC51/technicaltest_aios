package com.aios.technicaltest.exceptions;

    
public class CustomException extends RuntimeException {

    public ExceptionType getException() {
        return exception;
    }

    private final ExceptionType exception;

    public CustomException(ExceptionType exception) {
        this.exception = exception;
    }
}
