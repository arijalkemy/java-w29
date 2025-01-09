package org.bootcamp;

public class Informe extends Documento {

    private String texto;
    private Integer cantPaginas;
    private String autor;
    private String revisor;

    @Override
    public void imprimir() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Informe{" +
                "texto='" + texto + '\'' +
                ", cantPaginas=" + cantPaginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}';
    }
}
