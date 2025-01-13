package org.example;

import org.example.model.PdfBooks;
import org.example.model.Reports;
import org.example.model.Resumes;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Resumes> resumes = new ArrayList<>();
        resumes.add(new Resumes("Nombre1", "Apellido1", 21, "nombre1.apellido1@prueba.com", new ArrayList<>(List.of("Responsable", "Trabajo en equipo", "Java"))));
        resumes.add(new Resumes("Nombre2", "Apellido2", 22, "nombre2.apellido2@prueba.com", new ArrayList<>(List.of("Responsable", "Trabajo en equipo", "Java"))));
        resumes.add(new Resumes("Nombre3", "Apellido3", 23, "nombre3.apellido3@prueba.com", new ArrayList<>(List.of("Responsable", "Trabajo en equipo", "Java"))));
        resumes.add(new Resumes("Nombre4", "Apellido4", 24, "nombre4.apellido4@prueba.com", new ArrayList<>(List.of("Responsable", "Trabajo en equipo", "Java"))));

        resumes.forEach(resume -> resume.print(resume));

        List<PdfBooks> pdfBooks = new ArrayList<>();
        pdfBooks.add(new PdfBooks("Libro1", "Titulo1", "Genero1", 123));
        pdfBooks.add(new PdfBooks("Libro2", "Titulo2", "Genero2", 234));
        pdfBooks.add(new PdfBooks("Libro3", "Titulo3", "Genero3", 345));
        pdfBooks.add(new PdfBooks("Libro4", "Titulo4", "Genero4", 456));

        pdfBooks.forEach(pdfBook -> pdfBook.print(pdfBook));

        List<Reports> reports = new ArrayList<>();
        reports.add(new Reports("Autor1", "Revisor1", 123, "Texto1"));
        reports.add(new Reports("Autor2", "Revisor2", 234, "Texto2"));
        reports.add(new Reports("Autor3", "Revisor3", 345, "Texto3"));
        reports.add(new Reports("Autor4", "Revisor4", 456, "Texto4"));

        reports.forEach(report -> report.print(report));
    }
}