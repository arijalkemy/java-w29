package com.app.dto.response;

// US 0001 US 0007:
public class SuccessDTO {

    private String message;

    public SuccessDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
