package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Curriculum curriculo = new Curriculum(
                "Juan Pérez",
                "Carlos Rodríguez",
                Arrays.asList("Java", "SQL", "Spring", "Git")
        );

        LibroPDF libroPDF = new LibroPDF(
                "J.K. Rowling",
                "Harry Potter y la Piedra Filosofal",
                320,
                "Fantasía"
        );

        Informe informe = new Informe(
                "Ana Gómez",
                "Este es el texto del informe que cubre varios aspectos importantes.",
                5,
                "Luis Fernández"
        );

        Imprimible.imprimirDocumento(curriculo);
        System.out.println();
        Imprimible.imprimirDocumento(libroPDF);
        System.out.println();
        Imprimible.imprimirDocumento(informe);
    }
}
