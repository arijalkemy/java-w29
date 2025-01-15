package com.bootcamp.blog.exception;

public class BlogBadRequestException extends RuntimeException{

    public BlogBadRequestException(String message) {
        super(message);
    }
}
