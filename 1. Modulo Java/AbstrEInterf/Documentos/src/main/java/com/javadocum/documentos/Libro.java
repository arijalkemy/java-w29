package com.javadocum.documentos;

public class Libro extends Documento {

    Integer cantidadPaginas;
    String autor;
    String titulo;
    String genero;

    public Libro(Integer cantidadPaginas, String autor, String titulo, String genero) {
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Titulo: " + this.titulo + "   Genero: " + this.genero + "   Autor: " + this.autor + "   Nro. páginas: "
                + this.cantidadPaginas;
    }

}
