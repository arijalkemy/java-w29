package org.ejercicio2;

public class Informe extends Documento {

    private String texto;
    private int cantidadDePaginas;
    private String autor;
    private String revisor;

    public Informe(String texto, int cantidadDePaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getCantidadDePaginas() {
        return cantidadDePaginas;
    }

    public void setCantidadDePaginas(int cantidadDePaginas) {
        this.cantidadDePaginas = cantidadDePaginas;
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

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo contenido de " + imprimirTipoDocumento() + ":");
        System.out.println("Texto: " + texto);
        System.out.println("Cantidad de Paginas: " + cantidadDePaginas);
        System.out.println("Autor: " + autor);
        System.out.println("Revisor: " + revisor);
    }
}
