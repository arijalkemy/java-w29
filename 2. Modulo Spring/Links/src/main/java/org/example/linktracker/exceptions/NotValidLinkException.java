package org.example.linktracker.exceptions;

public class NotValidLinkException extends RuntimeException {
    public NotValidLinkException(String message) {
        super(message);
    }
}
