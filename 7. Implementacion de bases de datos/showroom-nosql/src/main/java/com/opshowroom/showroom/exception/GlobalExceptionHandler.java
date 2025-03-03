package com.opshowroom.showroom.exception;

import com.opshowroom.showroom.dto.response.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ClotheNotFoundException.class)
    public ResponseEntity<ResponseDTO> handleClotheNotFoundException(ClotheNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ResponseDTO<>(null, ex.getMessage(), false));
    }

    @ExceptionHandler(ClothesNotFoundException.class)
    public ResponseEntity<ResponseDTO> handleClothesNotFoundException(ClothesNotFoundException ex) {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(new ResponseDTO<>(null, ex.getMessage(), false));
    }

    @ExceptionHandler(SaleNotFoundException.class)
    public ResponseEntity<ResponseDTO> handleSaleNotFoundException(SaleNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ResponseDTO<>(null, ex.getMessage(), false));
    }

    @ExceptionHandler(SalesNotFoundException.class)
    public ResponseEntity<ResponseDTO> handleSalesNotFoundException(SalesNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ResponseDTO<>(null, ex.getMessage(), false));
    }

    @ExceptionHandler(InvalidDateFormatException.class)
    public ResponseEntity<ResponseDTO> handleInvalidDateFormatException(InvalidDateFormatException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ResponseDTO<>(null, ex.getMessage(), false));
    }
}
