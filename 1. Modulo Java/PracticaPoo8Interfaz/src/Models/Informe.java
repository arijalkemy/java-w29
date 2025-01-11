package Models;

import Interfaces.Imprimir;

public class Informe implements Imprimir {
    private String texto;
    private int cantPaginas;
    private String autor;
    private String revisor;

    public Informe(String texto, int cantPaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantPaginas = cantPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void imprimir() {
        System.out.println("Informe:");
        System.out.println("Texto: " + texto);
        System.out.println("Cantidad de Páginas: " + cantPaginas);
        System.out.println("Autor: " + autor);
        System.out.println("Revisor: " + revisor);
    }

    @Override
    public String tipoDocumento() {
        return "Informe";
    }
}
