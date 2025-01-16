package com.practicablogexepcion.blogexepcion.exception;

public class BlogNotFoundException extends RuntimeException {

    public BlogNotFoundException(int id) {
        super(String.format("No se encontró ningún blog con ID %d", id));
    }
}
