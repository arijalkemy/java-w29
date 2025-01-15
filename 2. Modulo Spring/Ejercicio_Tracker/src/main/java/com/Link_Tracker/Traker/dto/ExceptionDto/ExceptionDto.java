package com.Link_Tracker.Traker.dto.ExceptionDto;

public class ExceptionDto {
    private String message;

    public ExceptionDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
