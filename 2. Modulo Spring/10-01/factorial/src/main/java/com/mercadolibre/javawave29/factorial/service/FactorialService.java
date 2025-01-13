package com.mercadolibre.javawave29.factorial.service;

import org.springframework.stereotype.Service;

@Service
public class FactorialService {

    public String factorial(Long number) {
        if (number < 1) {
            throw new IllegalArgumentException("El número debe ser mayor o igual a 1");
        }
        int factorial = 1;
        for (long n = number; n>=1; n--) {
            factorial *= n;
        }
        return "El factorial de " + number + " es " + factorial;
    }
}
