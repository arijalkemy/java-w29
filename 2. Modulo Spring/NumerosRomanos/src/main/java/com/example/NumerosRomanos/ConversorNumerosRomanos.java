package com.example.NumerosRomanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversorNumerosRomanos {
    @GetMapping("/conversor/{numero}")
    public String convertirADecimal(@PathVariable int numero) {

        String[] romanos = {
                "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
        };
        int[] valores = {
                1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
        };

        StringBuilder resultado = new StringBuilder();

        int i = 0;
        while (numero > 0) {
            if (numero >= valores[i]) {
                resultado.append(romanos[i]);
                numero -= valores[i];
            } else {
                i++;
            }
        }

        return resultado.toString();
    }
}
