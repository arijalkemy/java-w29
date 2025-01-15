package com.thiagoschreck.local.link_tracker.exception;

public class LinkIdNotFoundException extends RuntimeException {
    public LinkIdNotFoundException(int linkId) {
        super(String.format("No se encontró un link con ID %d", linkId));
    }
}
