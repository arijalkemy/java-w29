package org.example.poo.part2;

public class LibroPDF implements Imprimible{

    private int cantidadPaginas;
    private String nombreAutor;
    private String titulo;

    public LibroPDF(int cantidadPaginas, String nombreAutor, String titulo) {
        this.cantidadPaginas = cantidadPaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
    }

    @Override
    public void imprimir() {
        System.out.println("Libro PDF");
        System.out.println("Cantidad de páginas: " + cantidadPaginas);
        System.out.println("Autor: " + nombreAutor);
        System.out.println("Título: " + titulo);
    }
}
