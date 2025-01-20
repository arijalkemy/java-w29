package org.melibootcamp.links.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(NotFound.class)
    public ResponseEntity<?> notFound(NotFound e){
       return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
