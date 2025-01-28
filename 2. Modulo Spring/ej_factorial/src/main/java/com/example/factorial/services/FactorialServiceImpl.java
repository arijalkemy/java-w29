package com.example.factorial.services;

import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class FactorialServiceImpl implements FactorialService {
    @Override
    public BigInteger factorial(Integer num) {
        if (num == 1 || num == 0) return BigInteger.ONE;
        return BigInteger.valueOf(num).multiply(factorial(num - 1));
    }
}
