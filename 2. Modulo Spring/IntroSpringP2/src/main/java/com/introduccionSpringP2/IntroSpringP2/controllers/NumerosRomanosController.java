package com.introduccionSpringP2.IntroSpringP2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanosController {
    @GetMapping("/{numero}")
 public String conversionNumeroARomano (@PathVariable Integer numero) {
    switch (numero){
        case 1:
            return "I";
        case 2:
            return "II";
        case 3:
            return "III";
        case 4:
            return "IV";
        case 5:
            return "V";
        case 7:
            return "VII";
        case 10:
            return "X";
        case 13:
            return "VIII";
        case 50:
            return "L";
        case 100:
            return "C";
        case 500:
            return "D";
        case 1000:
            return "M";
        default:
                return "Numero inexistente";
    }

 }
}
