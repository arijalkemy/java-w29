package org.example.model;

public class PDFBook implements Documents{

    private String titulo;
    private String autor;
    private String genero;
    private int cantidadPaginas;

    public PDFBook(String titulo, String autor, String genero, int cantidadPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.cantidadPaginas = cantidadPaginas;
    }

    @Override
    public String contentToPrint() {
        return "Libro PDF: " + titulo + " de " + autor + "\nGénero: " + genero + "\nPáginas: " + cantidadPaginas;
    }
}
