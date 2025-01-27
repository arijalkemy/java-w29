package com.bootcamp.be_java_hisp_w29_g07.exception;

/**
 * This class represents an exception for bad requests.
 * It extends RuntimeException and is used to indicate invalid client requests.
 */
public class BadRequestException extends RuntimeException {

    /**
     * Constructs a new BadRequestException with the specified message.
     *
     * @param message the detail message explaining the exception
     */
    public BadRequestException(String message) {
        super(message);
    }
}

