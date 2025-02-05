package com.blog.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.blog.blog.dto.ErrorDTO;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(IdAlreadyExistsException.class)
    public ResponseEntity<?> IdAlreadyExists (IdAlreadyExistsException exception) { 
        return new ResponseEntity<>(new ErrorDTO("ID already exists, message: "+ exception.getMessage()), HttpStatus.CONFLICT);
    }
    
}
