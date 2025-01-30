package com.example.numerosromanos.controllers;

import com.example.numerosromanos.services.NumerosRomanosService;
import com.example.numerosromanos.services.NumerosRomanosServiceImpl;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class Controller {

    private final NumerosRomanosService service;

    @GetMapping("/{numeroDecimal}")
    public ResponseEntity<String> convertir(@Positive @PathVariable Integer numeroDecimal) {
        String numeroRomano = service.decimalToRoman(numeroDecimal);
        return ResponseEntity.ok(numeroRomano);
    }
}
