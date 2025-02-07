package com.thiagoschreck.local.melisocial.exception;

public class IdMustNotBeNullException extends RuntimeException {
    public IdMustNotBeNullException() {
        super("The ID must not be null");
    }
}
