package com.ejemplodeinyecciondependencias.book.exceptions;

public class NotFoundExceptionBook extends RuntimeException{

    public NotFoundExceptionBook(String message){
        super(message);
    }

}
