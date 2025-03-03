package org.meli.qatesters.exception;

import org.meli.qatesters.dto.response.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = TestCaseNotFoundException.class)
    public ResponseEntity<ResponseDTO> handleTestCaseNotFoundException(TestCaseNotFoundException exception) {
        ResponseDTO response = new ResponseDTO(null, exception.getMessage(), false);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(value = TestCasesNotFoundException.class)
    public ResponseEntity<ResponseDTO> handleTestsCasesNotFoundException(TestCasesNotFoundException exception) {
        ResponseDTO response = new ResponseDTO(null, exception.getMessage(), false);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(value = InvalidDateFormatException.class)
    public ResponseEntity<ResponseDTO> handleInvalidDateFormatException(InvalidDateFormatException exception) {
        ResponseDTO response = new ResponseDTO(null, exception.getMessage(), false);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

}
