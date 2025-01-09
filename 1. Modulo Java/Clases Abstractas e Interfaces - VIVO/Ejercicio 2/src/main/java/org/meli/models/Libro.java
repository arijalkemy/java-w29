package org.meli.models;

import org.meli.interfaces.Imprimible;

public class Libro implements Imprimible {
    private String titulo;
    private String autor;
    private String genero;
    private int paginas;

    public Libro(String titulo, String autor, String genero, int paginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.paginas = paginas;
    }

    @Override
    public String obtenerContenido() {
        return "Libro en PDF:\n" +
                "Título: " + titulo + "\n" +
                "Autor: " + autor + "\n" +
                "Género: " + genero + "\n" +
                "Páginas: " + paginas;
    }
}
