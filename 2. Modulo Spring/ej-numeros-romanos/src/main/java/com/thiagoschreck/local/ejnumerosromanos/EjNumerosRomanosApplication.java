package com.thiagoschreck.local.ejnumerosromanos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.function.BiFunction;

@SpringBootApplication
public class EjNumerosRomanosApplication {

    public static void main(String[] args) {
        prueba((String a, String b) -> a + " " + b);

        SpringApplication.run(EjNumerosRomanosApplication.class, args);
    }

    private static void prueba(BiFunction<String, String, String> funcion1) {
        System.out.println(funcion1);
    }
}