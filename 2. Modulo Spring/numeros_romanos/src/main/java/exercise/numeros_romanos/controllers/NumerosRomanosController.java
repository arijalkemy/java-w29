package exercise.numeros_romanos.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NumerosRomanosController {

    @GetMapping("convertir-a-romano/{numero}")
    public String convertToRoman(@PathVariable int numero) {

        StringBuilder roman = new StringBuilder();
        int aux = numero;
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        if (numero <= 0){
            return "El número no puede ser menor o igual a 0";
        }

            for(int i = 0; i < symbols.length; i++) {
                while (values[i] <= aux) {
                    roman.append(symbols[i]);
                    aux -= values[i];
                }
            }

    return roman.toString();
    }
}
