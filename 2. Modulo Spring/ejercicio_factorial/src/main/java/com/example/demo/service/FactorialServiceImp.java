package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class FactorialServiceImp implements FactorialService {


    @Override
    public Long factorial(Long num) {
        if (num < 0) {
            throw new IllegalArgumentException("El número debe ser no negativo");
        }
        long result = 1L;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}
