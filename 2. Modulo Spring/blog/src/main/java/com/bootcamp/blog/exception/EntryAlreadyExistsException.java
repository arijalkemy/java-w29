package com.bootcamp.blog.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@NoArgsConstructor
public class EntryAlreadyExistsException extends RuntimeException{
    public EntryAlreadyExistsException(String message){
        super(message);
    }
}
