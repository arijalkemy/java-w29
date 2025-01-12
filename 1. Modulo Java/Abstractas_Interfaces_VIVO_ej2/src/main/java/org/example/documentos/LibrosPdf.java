package org.example.documentos;

public class LibrosPdf extends Documento {
    private String autor;
    private String titulo;
    private String genero;
    private int paginas;

    public LibrosPdf(int paginas, String genero, String titulo, String autor) {
        this.paginas = paginas;
        this.genero = genero;
        this.titulo = titulo;
        this.autor = autor;
    }

    @Override
    public void imprimir() {
        System.out.println("Autor: " + autor);
        System.out.println("Titulo: " + titulo);
        System.out.println("Genero: " + genero);
        System.out.println("Paginas: " + paginas);
    }
}
