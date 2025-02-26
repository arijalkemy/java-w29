package com.javadocum.documentos;

public class Informe extends Documento {

    String texto;
    Integer cantidadPaginas;
    String autor;
    String revisor;

    public Informe(String texto, Integer cantidadPaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return "Autor: " + this.autor + "   Revisor:" + this.revisor + "   Nro. páginas: " + this.cantidadPaginas
                + "   Texto: " + this.texto;
    }

}
