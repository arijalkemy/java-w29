package com.mercadolibre.javawave29.romannumbers.service;

import org.springframework.stereotype.Service;

@Service
public class RomanService {
    public String toRoman(int number) {
        if (number <= 0 || number > 3999) {
            throw new IllegalArgumentException("El número debe estar entre 1 y 3999");
        }
        int originalNumber = number;
        StringBuilder roman = new StringBuilder();
        int[]    values =      {1000, 900, 500, 400, 100,   90,  50,  40,   10,   9,    5,   4,    1};
        String[] symbols =      {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                number -= values[i];
                // 3888 -> 2888 -> 1888 -> 888 -> 388 -> 288 -> 188 -> 88 -> 38 -> 28 -> 18 -> 8 -> 3 -> 2 -> 1 -> FIN
                //  M        M      M       D      C      C      C      L     X     X     X    V    I    I    I
                roman.append(symbols[i]);
            }
        }
        return "El numero " + originalNumber + " en números romanos es: " + roman;
    }
}
