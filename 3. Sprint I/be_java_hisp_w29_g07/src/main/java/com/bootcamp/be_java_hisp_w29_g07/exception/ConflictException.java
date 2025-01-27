package com.bootcamp.be_java_hisp_w29_g07.exception;

/**
 * Custom exception to represent conflict errors.
 */
public class ConflictException extends RuntimeException {

    /**
     * Creates a ConflictException with a specific error message.
     *
     * @param message the error message
     */
    public ConflictException(String message) {
        super(message);
    }

}
