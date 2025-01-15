package com.thiagoschreck.local.link_tracker.exception;

public class DisabledLinkException extends RuntimeException {
    public DisabledLinkException(int linkId) {
        super(String.format("The link with ID %d is disabled", linkId));
    }
}
