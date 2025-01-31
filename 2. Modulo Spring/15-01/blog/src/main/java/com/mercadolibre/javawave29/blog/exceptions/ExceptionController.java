package com.mercadolibre.javawave29.blog.exceptions;

import com.mercadolibre.javawave29.blog.dto.GenericErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<GenericErrorDTO> conflictException(ConflictException e) {
        GenericErrorDTO error = new GenericErrorDTO(e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT.value()).body(error);
    }

    @ExceptionHandler(InternalError.class)
    public ResponseEntity<GenericErrorDTO> internalException(InternalError e) {
        GenericErrorDTO error = new GenericErrorDTO(e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<GenericErrorDTO> notFoundException(NotFoundException e) {
        GenericErrorDTO error = new GenericErrorDTO(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
    }
}
