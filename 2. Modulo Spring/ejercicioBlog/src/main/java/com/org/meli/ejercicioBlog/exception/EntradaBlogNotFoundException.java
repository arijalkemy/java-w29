package com.org.meli.ejercicioBlog.exception;

public class EntradaBlogNotFoundException extends RuntimeException {
    public EntradaBlogNotFoundException(Integer id) {
        super("No se encontró la entrada con id: " + id);
    }

    public EntradaBlogNotFoundException() {
        super("No se encontraron entradas en el blog.");
    }
}
