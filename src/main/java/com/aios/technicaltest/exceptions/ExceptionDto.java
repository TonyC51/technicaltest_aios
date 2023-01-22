package com.aios.technicaltest.exceptions;

import java.time.LocalDateTime;

public class ExceptionDto {
    
    private String path;
    private String errormessage;
    private String timestamp = LocalDateTime.now().toString();

    public ExceptionDto() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getErrormessage() {
        return errormessage;
    }

    public void setErrormessage(String errormessage) {
        this.errormessage = errormessage;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public ExceptionDto(String path, String errormessage) {
        this.path = path;
        this.errormessage = errormessage;
    }
}
