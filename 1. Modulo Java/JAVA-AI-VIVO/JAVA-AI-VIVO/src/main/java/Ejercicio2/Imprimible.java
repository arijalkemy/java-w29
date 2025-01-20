package Ejercicio2;

public interface Imprimible {

    static void imprimir(Object documento) {
        if (documento instanceof Curriculum) {
            Curriculum c = (Curriculum) documento;
            System.out.println("---- Curriculum ----");
            System.out.println("Nombre: " + c.getNombre());
            System.out.println("Edad: " + c.getEdad());
            System.out.println("Habilidades: " + String.join(", ", c.getHabilidades()));
        } else if (documento instanceof LibroPDF) {
            LibroPDF libro = (LibroPDF) documento;
            System.out.println("---- Libro PDF ----");
            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Autor: " + libro.getAutor());
            System.out.println("Género: " + libro.getGenero());
            System.out.println("Páginas: " + libro.getPaginas());
        } else if (documento instanceof Informe) {
            Informe informe = (Informe) documento;
            System.out.println("---- Informe ----");
            System.out.println("Texto: " + informe.getTexto());
            System.out.println("Autor: " + informe.getAutor());
            System.out.println("Revisor: " + informe.getRevisor());
            System.out.println("Páginas: " + informe.getPaginas());
        } else {
            System.out.println("Tipo de documento desconocido.");
        }
    }}
