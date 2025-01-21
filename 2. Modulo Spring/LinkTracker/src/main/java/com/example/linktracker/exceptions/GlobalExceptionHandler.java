package com.example.linktracker.exceptions;

import com.example.linktracker.dto.response.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotValidUrl.class)
    public ResponseEntity<ExceptionDto> handleNotValidUrl(NotValidUrl e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ExceptionDto.builder().message(e.getMessage()).build());
    }
}
