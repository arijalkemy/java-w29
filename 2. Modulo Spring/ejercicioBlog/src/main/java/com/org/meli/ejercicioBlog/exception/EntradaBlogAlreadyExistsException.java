package com.org.meli.ejercicioBlog.exception;

public class EntradaBlogAlreadyExistsException extends RuntimeException {
    public EntradaBlogAlreadyExistsException(Integer id) {
        super("La entrada con id " + id + " ya existe en el blog.");
    }
}
