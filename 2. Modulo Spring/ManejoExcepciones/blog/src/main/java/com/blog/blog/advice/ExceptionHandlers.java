package com.blog.blog.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.blog.blog.dto.ErrorDTO;
import com.blog.blog.exception.IdAlreadyExistsException;
import com.blog.blog.exception.NotFoundException;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(IdAlreadyExistsException.class)
    public ResponseEntity<?> IdAlreadyExists (IdAlreadyExistsException exception) { 
        ErrorDTO error = new ErrorDTO("ID already exists, message: "+ exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
    
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDTO> BlogNotFound (Exception e) {
        ErrorDTO error = new ErrorDTO("Blog not found, message: "+ e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    
}
