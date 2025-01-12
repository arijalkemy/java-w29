package org.example.documentos;

public class Informes extends Documento {
    private String texto;
    private int paginas;
    private String autor;
    private String revisor;

    public Informes(String texto, int paginas, String autor, String revisor) {
        this.texto = texto;
        this.paginas = paginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void imprimir() {
        System.out.println("Autor: " + autor);
        System.out.println("Revisor: " + revisor);
        System.out.println("Páginas: " + paginas);
        System.out.println(texto);
    }
}
