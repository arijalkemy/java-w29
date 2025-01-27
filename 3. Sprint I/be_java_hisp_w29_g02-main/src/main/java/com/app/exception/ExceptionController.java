package com.app.exception;

import com.app.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionDTO> badRequest(BadRequestException e){
        return new ResponseEntity<>(new ExceptionDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionDTO> notFound(EntityNotFoundException e){
        return new ResponseEntity<>(new ExceptionDTO(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<ExceptionDTO> forbidden(ForbiddenException e){
        return new ResponseEntity<>(new ExceptionDTO(e.getMessage()), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ExceptionDTO> conflict(ConflictException e){
        return new ResponseEntity<>(new ExceptionDTO(e.getMessage()), HttpStatus.CONFLICT);
    }
}
