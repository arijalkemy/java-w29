package org.example;

public class Informe extends Documento {
    private String texto;
    private int cantidadDePaginas;
    private String revisor;

    public Informe(String autor, String texto, int cantidadDePaginas, String revisor) {
        super(autor);
        this.texto = texto;
        this.cantidadDePaginas = cantidadDePaginas;
        this.revisor = revisor;
    }

    public String getTexto() {
        return texto;
    }

    public int getCantidadDePaginas() {
        return cantidadDePaginas;
    }

    public String getRevisor() {
        return revisor;
    }

    @Override
    public void imprimir() {
        System.out.println("Informe de " + autor);
        System.out.println("Revisor: " + revisor);
        System.out.println("Cantidad de páginas: " + cantidadDePaginas);
        System.out.println("Texto: " + texto);
    }
}

