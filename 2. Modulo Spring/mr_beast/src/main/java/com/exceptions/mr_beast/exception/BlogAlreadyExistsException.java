package com.exceptions.mr_beast.exception;

public class BlogAlreadyExistsException extends RuntimeException {
    public BlogAlreadyExistsException(String message) {
        super(message);
    }
}
