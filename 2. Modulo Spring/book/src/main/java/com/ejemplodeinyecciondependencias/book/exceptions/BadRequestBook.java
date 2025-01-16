package com.ejemplodeinyecciondependencias.book.exceptions;

public class BadRequestBook extends RuntimeException{

    public BadRequestBook() {
    }

    public BadRequestBook(String message){
        super(message);
    }
}
