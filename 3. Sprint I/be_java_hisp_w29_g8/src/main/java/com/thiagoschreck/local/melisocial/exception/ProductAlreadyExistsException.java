package com.thiagoschreck.local.melisocial.exception;

public class ProductAlreadyExistsException extends RuntimeException {
	public ProductAlreadyExistsException(int productId) {
		super(String.format("Product with ID %d already exists!", productId));
	}
}
