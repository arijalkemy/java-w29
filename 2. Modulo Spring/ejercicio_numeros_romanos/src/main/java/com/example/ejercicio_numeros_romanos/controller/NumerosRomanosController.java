package com.example.ejercicio_numeros_romanos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class NumerosRomanosController {
    private List<Integer> decimales = new ArrayList<>();
    private List<String> nrosRomanos = new ArrayList<>();

    public NumerosRomanosController() {
        decimales = List.of(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);
        nrosRomanos = List.of("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I");
    }

    @GetMapping("/decimalARomano/{numero}")
    public ResponseEntity<String> traduccion(@PathVariable Integer numero) {
        Integer auxDecimal = numero;
        String resultado = "";

        for(int i = 0; i < decimales.size(); i++) {
            while(decimales.get(i) <= auxDecimal) {
                auxDecimal -= decimales.get(i);
                resultado += nrosRomanos.get(i);
            }
        }

        return ResponseEntity.ok(resultado);
    }

}
