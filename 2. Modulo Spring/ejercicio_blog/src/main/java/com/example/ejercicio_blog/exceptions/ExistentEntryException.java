package com.example.ejercicio_blog.exceptions;

public class ExistentEntryException extends RuntimeException {
    public ExistentEntryException(String message) {
        super(message);
    }
}
