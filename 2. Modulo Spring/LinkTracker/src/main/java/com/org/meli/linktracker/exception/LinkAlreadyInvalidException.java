package com.org.meli.linktracker.exception;

public class LinkAlreadyInvalidException extends RuntimeException {
    public LinkAlreadyInvalidException(String message) {
        super(message);
    }
}
