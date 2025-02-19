package com.meli.seguroDeAutos.exception;

public class AlreadyException extends RuntimeException{
    private String message;

    public AlreadyException(String message){
        super(message);
    }
}
