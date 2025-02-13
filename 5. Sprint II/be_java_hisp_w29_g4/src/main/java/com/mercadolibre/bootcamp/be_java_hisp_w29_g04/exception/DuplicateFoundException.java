package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.exception;

public class DuplicateFoundException extends RuntimeException {
    public DuplicateFoundException(String message) {
        super(message);
    }
}
