package org.example.manejo_excepciones_1_vivo.exeption;

public class BlogNotFoundException extends RuntimeException {
    public BlogNotFoundException(String message) {
        super(message);
    }
}
