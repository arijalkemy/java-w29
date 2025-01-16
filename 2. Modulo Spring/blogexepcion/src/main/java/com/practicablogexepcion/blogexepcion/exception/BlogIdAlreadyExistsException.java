package com.practicablogexepcion.blogexepcion.exception;

public class BlogIdAlreadyExistsException extends RuntimeException {

    public BlogIdAlreadyExistsException(int id) {
        super(String.format("Ya existe un blog con el ID %d", id));
    }
}
