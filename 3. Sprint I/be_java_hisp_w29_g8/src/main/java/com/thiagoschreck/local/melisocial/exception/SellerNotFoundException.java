package com.thiagoschreck.local.melisocial.exception;

public class SellerNotFoundException extends RuntimeException {
    public SellerNotFoundException(int sellerId) {
        super(String.format("Could not find seller with ID %d", sellerId));
    }
}
