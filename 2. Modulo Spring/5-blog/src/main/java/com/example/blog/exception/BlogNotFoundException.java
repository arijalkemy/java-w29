package com.example.blog.exception;

public class BlogNotFoundException extends RuntimeException{
    public BlogNotFoundException(String m){
        super(m);
    }
}
