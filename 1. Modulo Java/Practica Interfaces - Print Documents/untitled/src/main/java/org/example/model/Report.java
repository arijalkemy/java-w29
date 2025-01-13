package org.example.model;

public class Report implements Documents{

    private String texto;
    private int cantidadPaginas;
    private String autor;
    private String revisor;

    public Report(String texto, int cantidadPaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public String contentToPrint() {
        return "Report de " + autor + "\nRevisor: " + revisor + "\nPáginas: " + cantidadPaginas + "\nTexto: " + texto;
    }

}
