package com.thiagoschreck.local.melisocial.exception;

public class HasDiscountMustBeTrueException extends RuntimeException {
    public HasDiscountMustBeTrueException() {
        super("has_promo field must be true to add a discounted product");
    }
}
