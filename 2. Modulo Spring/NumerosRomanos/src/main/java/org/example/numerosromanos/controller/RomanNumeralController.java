package org.example.numerosromanos.controller;

import org.example.numerosromanos.services.RomanNumeralConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/numeros")
public class RomanNumeralController {

    @Autowired
    private RomanNumeralConverter romanNumeralConverter;

    @GetMapping("/romano")
    public ResponseEntity<String> convertirANumeroRomano(@RequestParam("decimal") double numeroDecimal) {
        // Redondear el número decimal a entero
        int numeroEntero = (int) Math.round(numeroDecimal);

        // Comprobar si el número entero es menor que 1
        if (numeroEntero < 1) {
            return ResponseEntity.badRequest().body("El número debe ser mayor que 0 para ser convertido a número romano.");
        }

        // Convertir a número romano
        String numeroRomano = romanNumeralConverter.convertToRoman(numeroEntero);
        return ResponseEntity.ok(numeroRomano);
    }
}
