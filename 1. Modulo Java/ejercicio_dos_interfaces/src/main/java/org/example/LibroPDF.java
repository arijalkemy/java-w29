package org.example;

public class LibroPDF extends Documento {
    private String titulo;
    private int cantidadDePaginas;
    private String genero;

    public LibroPDF(String autor, String titulo, int cantidadDePaginas, String genero) {
        super(autor);
        this.titulo = titulo;
        this.cantidadDePaginas = cantidadDePaginas;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getCantidadDePaginas() {
        return cantidadDePaginas;
    }

    public String getGenero() {
        return genero;
    }

    @Override
    public void imprimir() {
        System.out.println("Libro PDF: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Género: " + genero);
        System.out.println("Cantidad de páginas: " + cantidadDePaginas);
    }
}
