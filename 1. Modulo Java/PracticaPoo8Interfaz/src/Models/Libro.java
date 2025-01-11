package Models;

import Interfaces.Imprimir;

public class Libro implements Imprimir {
    private String titulo;
    private String autor;
    private String revisora;
    private String texto;
    private int cantPaginas;

    public Libro(String titulo, String autor, String revisora, String texto, int cantPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.revisora = revisora;
        this.texto = texto;
        this.cantPaginas = cantPaginas;
    }


    @Override
    public void imprimir() {
        System.out.println("Información del Libro:");
        System.out.println("Autor: " + autor);
        System.out.println("Título: " + titulo);
        System.out.println("Texto: " + texto);
        System.out.println("Revisora: " + revisora);
        System.out.println("Cantidad de Páginas: " + cantPaginas);
    }

    @Override
    public String tipoDocumento() {
        return "Libro";
    }
}
