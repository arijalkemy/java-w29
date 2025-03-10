package com.bootcamp.linktracker.exception;

public class BadUrlException extends RuntimeException {
    public BadUrlException(String message) {
        super(message);
    }
}
