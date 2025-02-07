package com.thiagoschreck.local.melisocial.exception;

public class MissingUsernameException extends RuntimeException {
    public MissingUsernameException() {
        super("The username can not be empty");
    }
}
