package com.example.demo.abstractClass.ej_2;

public class LibroPDF implements Imprimible {
    private String titulo;
    private String autor;
    private String genero;
    private int cantidadPaginas;

    public LibroPDF(String titulo, String autor, String genero, int cantidadPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.cantidadPaginas = cantidadPaginas;
    }

    @Override
    public String obtenerContenido() {
        return "Libro en PDF:\n" +
                "Título: " + titulo + "\n" +
                "Autor: " + autor + "\n" +
                "Género: " + genero + "\n" +
                "Cantidad de Páginas: " + cantidadPaginas;
    }
}
