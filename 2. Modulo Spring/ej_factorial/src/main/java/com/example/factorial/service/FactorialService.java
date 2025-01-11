package com.example.factorial.service;

import org.springframework.stereotype.Service;

@Service
public class FactorialService {

    public int calcularFactorial(int num) {
        if (num < 0) throw new IllegalArgumentException("Tiene que ser un número no negativo");
        if (num > 100) throw new IllegalArgumentException("Ingrese un número no tan grande (máximo 100)");
        return factorial(num);
    }

    private int factorial(int num) {
        if (num == 1 || num == 0) return 1;
        return calcularFactorial(num - 1) * num;
    }

}
