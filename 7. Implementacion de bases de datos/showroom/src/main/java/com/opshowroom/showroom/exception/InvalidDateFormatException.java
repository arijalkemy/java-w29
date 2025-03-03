package com.opshowroom.showroom.exception;

public class InvalidDateFormatException extends RuntimeException {
    public InvalidDateFormatException() {
        super("Invalid date format. The correct format is dd/MM/yyyy");
    }
}
