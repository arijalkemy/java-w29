package org.meli;

import org.meli.interfaces.Imprimible;
import org.meli.models.Curriculum;
import org.meli.models.Informe;
import org.meli.models.Libro;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum(
                "Carolina Comba",
                21,
                "Córdoba, Argentina",
                List.of("Java", "Spring Boot", "Angular", "SQL")
        );

        Libro libro = new Libro(
                "El Principito",
                "Alguien",
                "Ficción",
                100
        );

        Informe informe = new Informe(
                "Contenido del informe",
                12,
                "María López",
                "Carlos Pérez"
        );

        Imprimible.imprimir(curriculum);
        Imprimible.imprimir(libro);
        Imprimible.imprimir(informe);
    }
}