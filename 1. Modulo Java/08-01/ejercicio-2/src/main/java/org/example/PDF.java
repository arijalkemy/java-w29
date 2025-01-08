package org.example;

public class PDF extends Documento {
    private int cantPaginas;
    private String autor;
    private String titulo;
    private String genero;

    public PDF(int cantPaginas, String autor, String titulo, String genero) {
        this.cantPaginas = cantPaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "PDF{" +
                "cantPaginas=" + cantPaginas +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
