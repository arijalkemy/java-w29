package com.bootcamp.exception;

public class PersonajeNotFound extends RuntimeException {
    public PersonajeNotFound(String message) {
        super(message);
    }
}
