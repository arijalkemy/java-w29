package org.example.ej_calculadora_calorias.Exception;


import org.example.ej_calculadora_calorias.Dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ConfigException {


    @ExceptionHandler(NoFoundException.class)
    public ResponseEntity<?> noFoundException(NoFoundException e) {
        ErrorDTO errorDTO = new ErrorDTO( e.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

}
