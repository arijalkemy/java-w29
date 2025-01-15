package com.example.ejercicio_blog.exceptions;

public class NotFoundEntryException extends RuntimeException {
    public NotFoundEntryException(String message) {
        super(message);
    }
}
