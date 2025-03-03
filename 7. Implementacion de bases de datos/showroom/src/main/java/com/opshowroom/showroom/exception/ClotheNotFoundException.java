package com.opshowroom.showroom.exception;

public class ClotheNotFoundException extends RuntimeException {
    public ClotheNotFoundException(Long id) {
        super("Clothe not found with id: "+ id);
    }
}
