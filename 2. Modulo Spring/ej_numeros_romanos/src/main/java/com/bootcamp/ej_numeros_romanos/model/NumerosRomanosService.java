package com.bootcamp.ej_numeros_romanos.model;

import org.springframework.stereotype.Service;

@Service
public class NumerosRomanosService {

    private static final Integer[] valores = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] simbolos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};


    public String convertFromInteger(Integer numero) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < valores.length; i++) {
            while (numero >= valores[i]) {
                resultado.append(simbolos[i]);
                numero -= valores[i];
            }
        }

        return resultado.toString();
    }
}
