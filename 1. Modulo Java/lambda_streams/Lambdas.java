package com.example.demo.lambda_streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lambdas {
    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> pares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(pares);
        /* **************************************************** */
        List<String> nombres = Arrays.asList("ana", "pedro", "juan");

        List<String> nombresMayusculas = nombres.stream()
//              .map(nombre -> nombre.toUpperCase())
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(nombresMayusculas);
    }
}
