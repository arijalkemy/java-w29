package com.example.blog.exception;

public class BlogAlreadyExistsException extends RuntimeException{
    public BlogAlreadyExistsException(String m){
        super(m);
    }
}
