package com.bootcamp.be_java_hisp_w29_g07.exception;

/**
 * Custom exception to represent not found errors.
 */
public class NotFoundException extends RuntimeException {

    /**
     * Creates a NotFoundException with a specific error message.
     *
     * @param message the error message
     */
    public NotFoundException(String message) {
        super(message);
    }
}

