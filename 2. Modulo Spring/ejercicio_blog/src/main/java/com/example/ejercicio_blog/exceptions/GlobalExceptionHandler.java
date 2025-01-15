package com.example.ejercicio_blog.exceptions;

import com.example.ejercicio_blog.dto.response.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {
    @ExceptionHandler(ExistentEntryException.class)
    public ResponseEntity<?> handleExistentEntryException(ExistentEntryException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ExceptionDto.builder().message(e.getMessage()).build());
    }

    @ExceptionHandler(NotFoundEntryException.class)
    public ResponseEntity<?> handleNotFoundEntryException(NotFoundEntryException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ExceptionDto.builder().message(e.getMessage()).build());
    }
}
