package com.meli.obtenerdiploma.exception;

import org.springframework.http.HttpStatus;

public class StudentNotFoundException extends ObtenerDiplomaException {

    public StudentNotFoundException(Long id) {
        super("El alumno con Id " + id + " no se encuetra registrado.", HttpStatus.NOT_FOUND);
    }

    /*
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    } */
}
