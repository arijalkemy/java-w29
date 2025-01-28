package org.example.numerosromanos.services;

import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

@Service
public class RomanNumeralConverter {

    private final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private final String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String convertToRoman(int number) {
        // Asegúrate de que el número esté dentro del rango
        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException("Número fuera de rango (1-3999)");
        }

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                number -= values[i];
                roman.append(symbols[i]);
            }
        }

        return roman.toString();
    }
}