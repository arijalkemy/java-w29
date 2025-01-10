package org.example.documentos;

public class LibroEnPDF extends Documento implements Imprimible{
    private String autor;
    private String titulo;
    private String genero;

    public LibroEnPDF(Integer cantidadDePaginas, String autor, String titulo, String genero) {
        super(cantidadDePaginas);
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "LibroEnPDF{" +
                "cantidadDePaginas=" + super.getCantidadDePaginas() +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }

    @Override
    public void imprimirDocumento() {
        System.out.println("Imprimiendo libro en PDF...\n" + this.toString() + "\n");
    }
}
