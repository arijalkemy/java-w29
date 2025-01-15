package com.example.ejercicio_blog.exception;

public class EntradaBlogAlreadyExistsException extends RuntimeException {
    public EntradaBlogAlreadyExistsException(String message) {
        super(message);
    }
}
