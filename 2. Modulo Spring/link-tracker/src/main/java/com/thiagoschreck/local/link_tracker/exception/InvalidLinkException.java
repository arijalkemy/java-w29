package com.thiagoschreck.local.link_tracker.exception;

public class InvalidLinkException extends RuntimeException {
    public InvalidLinkException(String url) {
        super(String.format("The URL %s is not a valid URL", url));
    }
}
