package com.example.demo.lambda_streams;

import java.util.*;
import java.util.stream.*;

public class Streams {

    public static void main(String[] args) {
        List<Persona> personas = Arrays.asList(
                new Persona("Ana", 30),
                new Persona("Pedro", 20),
                new Persona("Juan", 35),
                new Persona("Lucía", 25)
        );

        List<String> resultado = personas.stream()
                .filter(persona -> persona.getEdad() > 25) // WHERE edad > 25
                .map(Persona::getNombre) // SELECT nombre
                .collect(Collectors.toList()); // Convertir a lista

        System.out.println(resultado); // Salida: [Ana, Juan]
    }


}
