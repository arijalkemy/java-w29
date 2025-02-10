package org.melibootcamp.qatester.Exception;

import org.melibootcamp.qatester.dto.MessajeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExeptionController {
    @ExceptionHandler(TestNotFoundException.class)
    public ResponseEntity<MessajeDto> TestNotFoundExceptionxd(TestNotFoundException e) {
        return new ResponseEntity<MessajeDto>(new MessajeDto(e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
