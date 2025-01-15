package com.example.blog.exception;

import com.example.blog.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler(BlogNotFoundException.class)
    public ResponseEntity<?> handleBlogNotFoundException(BlogNotFoundException e){
        ErrorDto errorDto = new ErrorDto(e.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmptyBlogsException.class)
    public ResponseEntity<?> handleEmptyBlogsException(EmptyBlogsException e){
        ErrorDto errorDto = new ErrorDto(e.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.ACCEPTED);
    }

    @ExceptionHandler(BlogAlreadyExistsException.class)
    public ResponseEntity<?> handleBlogAlreadyExistsException(BlogAlreadyExistsException e) {
        ErrorDto errorDto = new ErrorDto(e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDto.getMensaje());
    }
}
