package com.bootcamp.manejo_excepciones_blog.exceptions;

public class BlogAlreadyExistsException extends Exception {
    public BlogAlreadyExistsException(String message) {
        super(message);
    }
}
