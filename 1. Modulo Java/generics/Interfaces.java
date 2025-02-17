package com.example.demo.generics;

import com.example.demo.deportistas.Persona;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Interfaces {

    static class ComparadorPorEdad implements Comparator<Persona> {
        @Override
        public int compare(Persona p1, Persona p2) {
            return Integer.compare(p1.getEdad(), p2.getEdad());
        }
    }

    public static void main(String[] args) {
            List<Persona> personas = Arrays.asList(
                    new Persona("Eliseo", 21),
                    new Persona("Ana", 30),
                    new Persona("Pedro", 18),
                    new Persona("Carla", 25)
            );

            System.out.println("Lista original:");
            personas.forEach(System.out::println);

            personas.sort(new ComparadorPorEdad());

            System.out.println("\nLista ordenada por edad:");
            personas.forEach(System.out::println);

            /*
            // Ordenar por edad usando una expresión lambda
            */

            System.out.println("Lista original:");
            personas.forEach(System.out::println);

            personas.sort((p1, p2) -> p1.getNombre().compareTo(p2.getNombre()));
  //        personas.sort(Comparator.comparingInt(Persona::getEdad));

            System.out.println("\nLista ordenada por nombre:");
            personas.forEach(System.out::println);
    }
}
