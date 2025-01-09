package com.thiagoschreck.local.documentos;

public class Informe extends Documento {
    private String texto;
    private int cantidadDePaginas;
    private String autor;
    private String revisor;

    public Informe(String texto, int cantidadDePaginas, String autor, String revisor) {
        super(String.format("Escrito por %s. Revisado por %s. %s páginas.%n%n\"%s\"", autor, revisor, cantidadDePaginas, texto));
        this.texto = texto;
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.revisor = revisor;
    }
}
