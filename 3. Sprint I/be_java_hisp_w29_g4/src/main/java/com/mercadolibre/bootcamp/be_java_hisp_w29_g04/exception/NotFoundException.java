package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
