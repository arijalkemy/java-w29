package com.opshowroom.showroom.exception;

public class SalesNotFoundException extends RuntimeException {
    public SalesNotFoundException() {
        super("Sales not found");
    }
}
