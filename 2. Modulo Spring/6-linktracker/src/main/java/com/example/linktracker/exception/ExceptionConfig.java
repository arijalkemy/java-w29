package com.example.linktracker.exception;

import com.example.linktracker.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ExceptionDto> conflicHandler(ConflictException e){
        ExceptionDto dto = new ExceptionDto(e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(dto);
    }

    @ExceptionHandler(InvalidLinkException.class)
    public ResponseEntity<ExceptionDto> invalidLinkHandler(InvalidLinkException e){
        ExceptionDto dto = new ExceptionDto(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> notFoundHandler(NotFoundException e){
        ExceptionDto dto = new ExceptionDto(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
    }
}
