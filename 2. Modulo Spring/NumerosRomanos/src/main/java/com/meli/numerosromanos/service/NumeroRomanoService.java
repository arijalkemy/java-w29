package com.meli.numerosromanos.service;

import java.util.*;

public class NumeroRomanoService {
    private static final List<Map.Entry<Integer, String>> romanos = new ArrayList<>();

    // !Dont change the order of de next static
    static {
        romanos.add(Map.entry(1000, "M"));
        romanos.add(Map.entry(900, "CM"));
        romanos.add(Map.entry(500, "D"));
        romanos.add(Map.entry(400, "CD"));
        romanos.add(Map.entry(100, "C"));
        romanos.add(Map.entry(90, "XC"));
        romanos.add(Map.entry(50, "L"));
        romanos.add(Map.entry(40, "XL"));
        romanos.add(Map.entry(10, "X"));
        romanos.add(Map.entry(9, "IX"));
        romanos.add(Map.entry(5, "V"));
        romanos.add(Map.entry(4, "IV"));
        romanos.add(Map.entry(1, "I"));
    }

    public String integerToRomano(int numero) {
        StringBuilder roman = new StringBuilder();

        for (Map.Entry<Integer, String> element : romanos) {
            System.out.println(element.getKey() + ": " + element.getValue() + " " + numero);
            while (numero >= element.getKey()) {
                roman.append(element.getValue());
                numero -= element.getKey();
            }
        }

        return roman.toString();
    }
}
