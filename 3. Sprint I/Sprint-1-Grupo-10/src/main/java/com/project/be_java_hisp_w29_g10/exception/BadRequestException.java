package com.project.be_java_hisp_w29_g10.exception;

public class BadRequestException extends  RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}
