package org.example;

import org.example.model.Curriculum;
import org.example.model.Documents;
import org.example.model.PDFBook;
import org.example.model.Report;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Curriculum curriculum = new Curriculum("Juan", "Pérez", 30, List.of("Java", "Spring Boot", "SQL"));
        PDFBook libroPDF = new PDFBook("El señor de los anillos", "J.R.R. Tolkien", "Fantasía", 1200);
        Report informe = new Report("Este es un análisis detallado de las ventas del último trimestre.", 10, "María López", "Carlos Gómez");

        Documents.imprimir(curriculum);
        System.out.println("----");
        Documents.imprimir(libroPDF);
        System.out.println("----");
        Documents.imprimir(informe);

    }
}