package com.aios.technicaltest.exceptions;

public enum ExceptionMessage {

    RECIPIENT_ALREADY_EXISTS("Recipient with this name already exists"),
    QUANTITY_SHOUD_BE_BETWEEN_0_AND_10000("Quantity should be at least 0 and max 10000"),
    QUANTITY_SHOULD_BE_MULTIPLE_OF_25("Quantity must be multiple of 25"),
    DATE_SHOULD_BE_IN_ATLEAST_ONE_WEEK("Delivery date should be in minimum one week");

    public String getMessage() {
        return message;
    }
    
    final String message;

    ExceptionMessage(String message) {
        this.message = message;
    } 
}
