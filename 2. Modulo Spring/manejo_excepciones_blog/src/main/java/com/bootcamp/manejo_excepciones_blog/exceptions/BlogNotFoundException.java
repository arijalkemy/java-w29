package com.bootcamp.manejo_excepciones_blog.exceptions;

public class BlogNotFoundException extends Exception {
    public BlogNotFoundException(String message) {
        super(message);
    }
}
