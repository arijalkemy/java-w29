package org.bootcamp.recapitulandospringp2.exception;

public class LinkInvalidatedException extends RuntimeException {
    public LinkInvalidatedException(String message) {
        super(message);
    }
}
