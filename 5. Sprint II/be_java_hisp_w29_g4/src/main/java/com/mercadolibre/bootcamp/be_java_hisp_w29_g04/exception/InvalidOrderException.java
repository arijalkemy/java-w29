package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.exception;

public class InvalidOrderException extends RuntimeException {
    public InvalidOrderException(String message) {
        super(message);
    }
}
