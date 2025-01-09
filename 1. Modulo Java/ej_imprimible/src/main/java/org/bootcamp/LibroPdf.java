package org.bootcamp;

public class LibroPdf extends Documento {

    private String genero;
    private Integer paginas;
    private String autor;
    private String titulo;

    @Override
    public void imprimir() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "LibroPdf{" +
                "genero='" + genero + '\'' +
                ", paginas=" + paginas +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
