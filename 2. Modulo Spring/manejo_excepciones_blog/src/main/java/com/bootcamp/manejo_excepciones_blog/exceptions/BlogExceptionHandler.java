package com.bootcamp.manejo_excepciones_blog.exceptions;

import com.bootcamp.manejo_excepciones_blog.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BlogExceptionHandler {

    @ExceptionHandler(BlogNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleBlogNotFoundException(BlogNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorDTO.builder().message(e.getMessage()).build());
    }

    @ExceptionHandler(BlogAlreadyExistsException.class)
    public ResponseEntity<ErrorDTO> handleBlogAleadyExistsException(BlogAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ErrorDTO.builder().message(e.getMessage()).build());
    }
}
