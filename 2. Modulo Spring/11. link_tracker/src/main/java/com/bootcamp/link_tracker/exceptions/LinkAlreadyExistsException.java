package com.bootcamp.link_tracker.exceptions;

public class LinkAlreadyExistsException extends RuntimeException{
    public LinkAlreadyExistsException(String message) {
        super(message);
    }
}
