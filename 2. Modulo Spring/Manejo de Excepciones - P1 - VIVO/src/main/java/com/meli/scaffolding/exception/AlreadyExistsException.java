package com.meli.scaffolding.exception;

public class AlreadyExistsException extends RuntimeException{
    public AlreadyExistsException(String m){
        super(m);
    }
}
