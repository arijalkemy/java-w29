package com.exceptions.mr_beast.exception;

public class BlogDoesNotExistException extends RuntimeException {
    public BlogDoesNotExistException(String message) {
        super(message);
    }
}
