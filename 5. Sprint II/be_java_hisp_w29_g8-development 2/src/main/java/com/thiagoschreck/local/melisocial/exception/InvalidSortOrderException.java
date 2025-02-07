package com.thiagoschreck.local.melisocial.exception;

public class InvalidSortOrderException extends RuntimeException {
	public InvalidSortOrderException() {
		super("The specified sort order is invalid. Please provide a valid order (e.g., 'name_asc' or 'name_desc').");
	}
}
