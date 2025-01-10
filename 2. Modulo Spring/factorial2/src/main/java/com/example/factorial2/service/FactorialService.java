package com.example.factorial2.service;

public class FactorialService {
    public Long factorial(Long base) {
        if (base == 0) {
            return 1l;
        }
        return base * factorial(base - 1);
    }
}
