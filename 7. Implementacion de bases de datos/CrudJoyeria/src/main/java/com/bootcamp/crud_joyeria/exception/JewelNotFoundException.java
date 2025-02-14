package com.bootcamp.crud_joyeria.exception;

public class JewelNotFoundException extends RuntimeException {
    public JewelNotFoundException(long jewelId) {
        super("Jewel not found with id " + jewelId);
    }
}
