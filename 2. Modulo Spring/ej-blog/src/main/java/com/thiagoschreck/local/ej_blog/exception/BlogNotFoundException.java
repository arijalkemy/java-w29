package com.thiagoschreck.local.ej_blog.exception;

public class BlogNotFoundException extends RuntimeException {

    public BlogNotFoundException(int id) {
        super(String.format("No se encontró ningún blog con ID %d", id));
    }
}
