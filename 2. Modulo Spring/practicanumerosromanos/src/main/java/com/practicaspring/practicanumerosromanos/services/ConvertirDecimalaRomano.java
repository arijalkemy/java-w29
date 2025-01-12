package com.practicaspring.practicanumerosromanos.services;

import org.springframework.stereotype.Service;

@Service
public class ConvertirDecimalaRomano {

    // Método para convertir un número decimal a número romano.
    public String convertToRoman(int numero) {
       /* if (numero <= 0 || numero > 3999) {
            throw new IllegalArgumentException("El número debe estar entre 1 y 3999.");
        }*/

        // Mapeo de valores decimales y sus equivalentes romanos.
        int[] decimalValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();

        // Convertir el número decimal al romano.
        for (int i = 0; i < decimalValues.length; i++) {
            while (numero >= decimalValues[i]) {
                roman.append(romanSymbols[i]);
                numero -= decimalValues[i];
            }
        }

        return roman.toString();
    }
}
