package com.example.ejercicio_blog.exception;

public class EntradaBlogAlreadyExistsException extends RuntimeException {
    public EntradaBlogAlreadyExistsException(Integer id) {
        super("La entrada con id " + id + " ya existe en el blog.");
    }
}
