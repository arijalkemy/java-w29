package com.example.factorial.service;

import org.springframework.stereotype.Service;

@Service
public class Services implements Iservice{
    @Override
    public int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
