package com.bootcamp.roman.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RomanService {

    enum Numeral {
        I(1),
        IV(4),
        V(5),
        IX(9),
        X(10),
        XL(40),
        L(50),
        XC(90),
        C(100),
        CD(400),
        D(500),
        CM(900),
        M(1000);

        final int weight;

        Numeral(int weight) {
            this.weight = weight;
        }
    };

    public String roman(long n) {

        if( n <= 0) {
            throw new IllegalArgumentException("Only positive numbers are allowed");
        }

        StringBuilder acc = new StringBuilder();

        final Numeral[] values = Numeral.values();
        for (int i = values.length - 1; i >= 0; i--) {
            while (n >= values[i].weight) {
                acc.append(values[i]);
                n -= values[i].weight;
            }
        }
        return acc.toString();
    }

}
