package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.exception;

public class ConflictException extends RuntimeException {
    public ConflictException(String message) {
        super(message);
    }
}
