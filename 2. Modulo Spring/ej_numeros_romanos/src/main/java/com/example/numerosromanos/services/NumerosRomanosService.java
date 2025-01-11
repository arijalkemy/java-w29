package com.example.numerosromanos.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NumerosRomanosService {

    private static final List<Integer> numerosDecimales = List.of(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);

    private static final List<String> numerosRomanos = List.of("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I");

    public String decimalToRoman(int num) {
        if (num <= 0 || num > 3999) {
            throw new IllegalArgumentException("Número fuera de rango (1-3999)");
        }

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < numerosDecimales.size(); i++) {
            while (num >= numerosDecimales.get(i)) {
                roman.append(numerosRomanos.get(i));
                num -= numerosDecimales.get(i);
            }
        }

        return roman.toString();
    }
}
