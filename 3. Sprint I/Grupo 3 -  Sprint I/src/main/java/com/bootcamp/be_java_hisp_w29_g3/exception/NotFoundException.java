package com.bootcamp.be_java_hisp_w29_g3.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
