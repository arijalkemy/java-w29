package com.factorial.appfactorial.service;


import org.springframework.stereotype.Service;

@Service
public class FactorialService {
    public Long calculateFactorial(Integer number) {
        long fact = 1L;
        for (int i = 1; i <= number; i++) {
            fact *= i;
        }

        return fact;
    }
}
