package com.numeros.romanos.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ConvertidorServiceImpl {
    private Map<String, String> numerosRomanos;

    public ConvertidorServiceImpl() {
        this.numerosRomanos = new HashMap<>();
        this.numerosRomanos.put("0", "0");
        this.numerosRomanos.put("1", "I");
        this.numerosRomanos.put("5", "V");
        this.numerosRomanos.put("10", "X");
        this.numerosRomanos.put("50", "L");
        this.numerosRomanos.put("100", "C");
        this.numerosRomanos.put("500", "D");
        this.numerosRomanos.put("1000", "M");
    }

    public String convertir(Integer num) {
        int[] valores = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] simbolos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < valores.length; i++) {
            while (num >= valores[i]) {
                num -= valores[i];
                roman.append(simbolos[i]);
            }
        }

        return roman.toString();
    }
}
