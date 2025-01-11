package com.bootcamp.clases;

public class LibroPdf extends Documento {
    private Integer cantidadPaginas;
    private String autor;
    private String titulo;
    private String genero;

    public Integer getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(Integer cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LibroPdf(Integer cantidadPaginas, String autor, String titulo, String genero) {
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        imprimirTipoDoc();
        System.out.println("Titulo: " + getTitulo().toUpperCase());
        System.out.println("Autor: " + getAutor());
        System.out.println("Genero: " + getGenero());
    }
}
