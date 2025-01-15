package com.example.blog.exception;

public class EmptyBlogsException extends RuntimeException{
    public EmptyBlogsException(String m){
        super(m);
    }
}
