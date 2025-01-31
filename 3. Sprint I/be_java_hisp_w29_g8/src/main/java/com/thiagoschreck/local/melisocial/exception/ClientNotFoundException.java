package com.thiagoschreck.local.melisocial.exception;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException() {
        super("Client not found!");
    }

    public ClientNotFoundException(int clientId) {
        super(String.format("Could not found client with ID %d", clientId));
    }
}
