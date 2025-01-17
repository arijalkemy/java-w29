package com.roman_numerals.controller;

import com.roman_numerals.servicio.ConvertService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumeralsController {
    private ConvertService convertService;

    public NumeralsController(ConvertService convertService) {
        this.convertService = convertService;
    }

    @GetMapping("/convert/{numero}")
    public ResponseEntity<String> convert(@PathVariable Integer numero){
        return ResponseEntity.ok(convertService.convert(numero));
    }
}
