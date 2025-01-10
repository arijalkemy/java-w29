package org.example.documentos;

public abstract class Documento{
    private Integer cantidadDePaginas;

    public Documento(Integer cantidadDePaginas) {
        this.cantidadDePaginas = cantidadDePaginas;
    }

    public abstract String toString();

    public Integer getCantidadDePaginas() {
        return cantidadDePaginas;
    }
}
