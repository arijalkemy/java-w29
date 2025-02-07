package com.thiagoschreck.local.melisocial.exception;

public class InvalidOrderValueException extends RuntimeException {
    public InvalidOrderValueException() {
        super("Debe enviar o date_asc para ordenar de forma ascendente o date_desc para ordenar de forma descendente.");
    }
}
