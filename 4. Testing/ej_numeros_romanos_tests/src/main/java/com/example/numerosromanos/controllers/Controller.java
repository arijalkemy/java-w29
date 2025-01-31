package com.example.numerosromanos.controllers;

import com.example.numerosromanos.services.NumerosRomanosService;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final NumerosRomanosService service;

    @Autowired
    public Controller(NumerosRomanosService service) {
        this.service = service;
    }

    @GetMapping("/{numeroDecimal}")
    public ResponseEntity<String> convertir(@Positive @PathVariable Integer numeroDecimal) {
        String numeroRomano = service.decimalToRoman(numeroDecimal);
        return ResponseEntity.ok(numeroRomano);
    }
}
