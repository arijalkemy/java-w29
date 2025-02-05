package com.blog.blog.exception;

public class IdAlreadyExistsException extends RuntimeException{

    public IdAlreadyExistsException(String message) {
        super(message);
    }
}
