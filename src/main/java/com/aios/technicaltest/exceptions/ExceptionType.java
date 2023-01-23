package com.aios.technicaltest.exceptions;

import org.springframework.http.HttpStatus;

public enum ExceptionType {

    RECIPIENT_ALREADY_EXISTS(HttpStatus.BAD_REQUEST, "Recipient with this name already exists"),
    QUANTITY_SHOUD_BE_BETWEEN_0_AND_10000(HttpStatus.BAD_REQUEST, "Quantity should be at least 0 and max 10000"),
    QUANTITY_SHOULD_BE_MULTIPLE_OF_25(HttpStatus.BAD_REQUEST, "Quantity must be multiple of 25"),
    DATE_SHOULD_BE_IN_ATLEAST_ONE_WEEK(HttpStatus.BAD_REQUEST, "Delivery date should be in minimum one week"),
    RECIPIENT_NOT_EXIST(HttpStatus.NOT_FOUND, "Cannot find recipient");

    public HttpStatus getStatus() {
        return status;
    }

    final HttpStatus status;
    private String message = null;

    public String getMessage() {
        return message;
    }

    ExceptionType(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
