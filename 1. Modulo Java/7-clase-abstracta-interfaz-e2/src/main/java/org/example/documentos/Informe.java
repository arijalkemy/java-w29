package org.example.documentos;

public class Informe extends Documento implements Imprimible{
    private String texto;
    private String autor;
    private String revisor;

    public Informe(Integer cantidadDePaginas, String texto, String autor, String revisor) {
        super(cantidadDePaginas);
        this.texto = texto;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return "Informe{" +
                "texto='" + texto + '\'' +
                ", cantidadPaginas=" + super.getCantidadDePaginas() +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}';
    }

    @Override
    public void imprimirDocumento() {
        System.out.println("Imprimiendo informe...\n" + this.toString() + "\n");
    }
}
