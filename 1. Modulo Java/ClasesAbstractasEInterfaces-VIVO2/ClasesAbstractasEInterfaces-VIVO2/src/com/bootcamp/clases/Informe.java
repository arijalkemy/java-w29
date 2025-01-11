package com.bootcamp.clases;

public class Informe extends Documento {
    private String texto;
    private Integer cantidadPaginas;
    private String autor;
    private String revisor;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

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

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    public Informe(String texto, Integer cantidadPaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void imprimir() {
        imprimirTipoDoc();
        System.out.println("Autor: " + getAutor());
        System.out.println("Revisor: " + getRevisor());
        System.out.println("Cantidad de paginas: " + getCantidadPaginas());
        System.out.println(getTexto());
    }
}
