package com.bootcamp.linkTracker.exception;

import com.bootcamp.linkTracker.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(InvalidLinkException.class)
    public ResponseEntity<?> invalidLinkException(Exception e){
        ErrorDTO dto = new ErrorDTO(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
    }

    @ExceptionHandler(PasswordException.class)
    public ResponseEntity<?> passwordException(Exception e){
        ErrorDTO dto = new ErrorDTO(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
    }
}
