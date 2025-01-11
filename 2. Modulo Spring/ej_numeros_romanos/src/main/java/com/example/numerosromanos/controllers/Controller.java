package com.example.numerosromanos.controllers;

import com.example.numerosromanos.services.NumerosRomanosService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class Controller {

    private final NumerosRomanosService service;

    @GetMapping("/{numeroDecimal}")
    public ResponseEntity<String> convertir(@PathVariable int numeroDecimal) {
        try {
            String numeroRomano = service.decimalToRoman(numeroDecimal);
            return ResponseEntity.ok(numeroRomano);
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}
