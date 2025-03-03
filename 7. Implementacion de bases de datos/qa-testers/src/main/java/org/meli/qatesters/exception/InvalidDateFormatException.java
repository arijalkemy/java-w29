package org.meli.qatesters.exception;

public class InvalidDateFormatException extends RuntimeException {
    public InvalidDateFormatException() {
        super("Invalid date format. The correct format is dd/MM/yyyy");
    }
}
