package com.bootcamp.manejo_excepciones_blog.exceptions;

public class BlogAlreadyExistsException extends RuntimeException {
    public BlogAlreadyExistsException(String message) {
        super(message);
    }
}
