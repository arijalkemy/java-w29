package com.example.linktracker.exceptions;

public class NotValidUrl extends RuntimeException {
    public NotValidUrl(String message) {
        super(message);
    }
}
