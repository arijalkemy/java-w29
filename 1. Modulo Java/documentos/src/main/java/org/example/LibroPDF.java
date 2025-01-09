package org.example;

public class LibroPDF implements Documento {
    private String titulo;
    private String autor;
    private String genero;
    private int cantidadPaginas;

    public LibroPDF(java.lang.String titulo, java.lang.String autor, java.lang.String genero, int cantidadPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    @Override
    public void imprimir() {
        System.out.println("Libro en PDF:");
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Género: " + genero);
        System.out.println("Cantidad de páginas: " + cantidadPaginas);
    }
}
