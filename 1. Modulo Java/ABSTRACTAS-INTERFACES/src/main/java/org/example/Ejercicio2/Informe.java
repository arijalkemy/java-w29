package org.example.Ejercicio2;

public class Informe implements Imprimible {
    //Atributos
    private String texto, autor, revisor;
    private int cantidadPaginas;

    //Constructor

    public Informe(String texto, String autor, String revisor, int cantidadPaginas) {
        this.texto = texto;
        this.autor = autor;
        this.revisor = revisor;
        this.cantidadPaginas = cantidadPaginas;
    }

    @Override
    public void imprimir() {
        System.out.println("Informe");
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Informe{" +
                "texto='" + texto + '\'' +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                ", cantidadPaginas=" + cantidadPaginas +
                '}';
    }
}
