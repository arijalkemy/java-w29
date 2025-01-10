package org.example.clases;
//ncluyen un texto de n longitud, cantidad de páginas, autor, y revisor.
public class Informe extends Documento{
    private String autor;
    private String revisor;
    private int pag;
    private String texto;

    //constructor
    public Informe(String autor, String revisor, int pag, String texto) {
        this.autor = autor;
        this.revisor = revisor;
        this.pag = pag;
        this.texto = texto;
    }

    //getter y stter

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

    public int getPag() {
        return pag;
    }

    public void setPag(int pag) {
        this.pag = pag;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    //implementar metodo imprimir
    @Override
    public void imprimir() {
        imprimirTipoDoc();
        System.out.println("Autor: " + autor);
        System.out.println("Revisor: " + revisor);
        System.out.println("Pag: " + pag);
        System.out.println("Texto: " + texto);
    }
}
