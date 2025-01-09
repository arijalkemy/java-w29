package com.thiagoschreck.local.documentos;

public class LibroEnPDF extends Documento {
    private int cantidadDePaginas;
    private String autor;
    private String titulo;
    private String genero;

    public LibroEnPDF(int cantidadDePaginas, String autor, String titulo, String genero) {
        super(String.format("%s - escrito por %s. Género: %s. %s páginas.", titulo, autor, genero, cantidadDePaginas));
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }
}
