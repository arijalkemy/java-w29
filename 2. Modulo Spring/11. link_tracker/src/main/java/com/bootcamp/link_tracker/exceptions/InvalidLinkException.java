package com.bootcamp.link_tracker.exceptions;

public class InvalidLinkException extends RuntimeException{
    public InvalidLinkException(String message) {
        super(message);
    }
}
