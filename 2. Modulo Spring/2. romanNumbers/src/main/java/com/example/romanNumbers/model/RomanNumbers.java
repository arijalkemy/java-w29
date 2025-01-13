package com.example.romanNumbers.model;

public enum RomanNumbers {
    M(1000), CM(900), D(500), CD(400),
    C(100), XC(90), L(50), XL(40),
    X(10), IX(9), V(5), IV(4), I(1);

    private int value;

    RomanNumbers(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static String toRoman(int numero) {
        StringBuilder resultado = new StringBuilder();

        for (RomanNumbers romano : RomanNumbers.values()) {
            while (numero >= romano.getValue()) {
                resultado.append(romano);
                numero -= romano.getValue();
            }
        }

        return resultado.toString();
    }
}
