package org.example.poo.part2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Curriculum curriculum = new Curriculum("Juan", "Pérez", "Calle Falsa 123", Arrays.asList("Java", "Python", "SQL"));

        LibroPDF libro = new LibroPDF(400,"Gabriel García Márquez", "Cien Años de Soledad");

        Informe informe = new Informe("Este es el texto del informe", 10, "Ana Gómez", "Carlos Rodríguez");

        System.out.println("=== Imprimir Curriculum ===");
        Imprimible.imprimir(curriculum);

        System.out.println("\n=== Imprimir Libro en PDF ===");
        Imprimible.imprimir(libro);

        System.out.println("\n=== Imprimir Informe ===");
        Imprimible.imprimir(informe);
    }
}