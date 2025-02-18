package com.bootcamp.ropita_extra.exception;

public class ClothesNotFoundException extends RuntimeException{
    public ClothesNotFoundException() {
        super("Clothes not found :(");
    }
}
