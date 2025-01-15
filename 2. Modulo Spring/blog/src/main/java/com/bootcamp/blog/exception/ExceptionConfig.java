package com.bootcamp.blog.exception;

import com.bootcamp.blog.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(BlogBadRequestException.class)
    public ResponseEntity<?> blogBadRequestException(Exception e){
        ErrorDTO dto = new ErrorDTO(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
    }

    @ExceptionHandler(BlogNotFoundException.class)
    public ResponseEntity<?> blogNotFoundException(Exception e){
        ErrorDTO dto = new ErrorDTO(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
    }

}
