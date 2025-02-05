package com.example.LinkTracker.exception;

public class AlreadyExistsLinkException extends RuntimeException {
    public AlreadyExistsLinkException(String message) {
        super(message);
    }
}
