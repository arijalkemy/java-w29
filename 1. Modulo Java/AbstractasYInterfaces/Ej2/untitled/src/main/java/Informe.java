package com.example.demo.abstractClass.ej_2;

public class Informe implements Imprimible {
    private String texto;
    private int cantidadPaginas;
    private String autor;
    private String revisor;

    public Informe(String texto, int cantidadPaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public String obtenerContenido() {
        return "Informe:\n" +
                "Texto: " + texto + "\n" +
                "Cantidad de Paginas: " + cantidadPaginas + "\n" +
                "Autor: " + autor + "\n" +
                "Revisor: " + revisor;
    }
}
