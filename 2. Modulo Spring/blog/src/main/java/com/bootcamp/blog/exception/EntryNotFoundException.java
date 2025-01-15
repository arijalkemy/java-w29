package com.bootcamp.blog.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EntryNotFoundException extends RuntimeException{
    public EntryNotFoundException(String message){
        super(message);
    }
}
