package com.example;

public class Main {
    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum(
                "Agostina",
                "Avalle",
                22,
                new String[]{"Java", "Spring Boot"}
        );

        Libro libro = new Libro(
                340,
                "Federico García Lorca",
                "Romancero gitano",
                "Peoma"
        );

        Informe informe = new Informe(
                "Lorem ipsum",
                3,
                "Autor random",
                "Revisor random"
        );

        Imprimible.imprimir(curriculum);
        Imprimible.imprimir(libro);
        Imprimible.imprimir(informe);
    }
}
