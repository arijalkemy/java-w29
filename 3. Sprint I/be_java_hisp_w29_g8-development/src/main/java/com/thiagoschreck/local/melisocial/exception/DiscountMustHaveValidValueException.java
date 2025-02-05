package com.thiagoschreck.local.melisocial.exception;

public class DiscountMustHaveValidValueException extends RuntimeException {
    public DiscountMustHaveValidValueException() {
        super("The discount field must be present and have a decimal value between 0 and 1");
    }
}
