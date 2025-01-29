package com.meli.obtenerdiploma.exception;

import com.meli.obtenerdiploma.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class ExceptionController  extends ResponseEntityExceptionHandler {
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionDTO> handleValidationException(HttpMessageNotReadableException ex){
        ExceptionDTO exceptionDTO = new ExceptionDTO("Error en la entrada de datos: "+ ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDTO);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDTO> handleValidationException(MethodArgumentNotValidException ex){
        ExceptionDTO exceptionDTO = new ExceptionDTO("Error en los parametros del metodo: "+ ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDTO);
    }
}
