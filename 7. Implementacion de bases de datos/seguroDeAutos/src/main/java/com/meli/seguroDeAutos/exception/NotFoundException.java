package com.meli.seguroDeAutos.exception;

public class NotFoundException extends RuntimeException{
    private String message;

    public NotFoundException(String message){
        super(message);
    }
}
