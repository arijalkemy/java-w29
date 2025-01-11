package com.example.factorial.service;

import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class FactorialService {

    public BigInteger calcularFactorial(Integer num) {
        if (num < 0) throw new IllegalArgumentException("Tiene que ser un número no negativo");
        if (num > 5000) throw new IllegalArgumentException("Ingrese un número no tan grande (máximo 5.000)");
        return factorial(num);
    }

    private BigInteger factorial(Integer num) {
        if (num == 1 || num == 0) return BigInteger.ONE;
        return BigInteger.valueOf(num).multiply(factorial(num - 1));
    }

}
