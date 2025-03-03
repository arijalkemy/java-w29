package com.opshowroom.showroom.exception;

public class ClothesNotFoundException extends RuntimeException {
    public ClothesNotFoundException() {
        super("Clothes not found");
    }
}
