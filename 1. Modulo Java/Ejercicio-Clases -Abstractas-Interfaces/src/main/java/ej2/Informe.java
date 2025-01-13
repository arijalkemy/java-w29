package ej2;

public class Informe extends Documento {
    private String contenidoInforme;
    private int cantidadPaginas;
    private String autor;
    private String revisor;

    public Informe(String contenidoInforme, int cantidadPaginas, String autor, String revisor) {
        super(
                "Informe: " +
                        "\n Contenido: " + contenidoInforme
                        + "\n Cantidad de paginas: " + cantidadPaginas
                        + "\n Autor: " + autor
                        + "\n Revisor: " + revisor
        );
        this.contenidoInforme = contenidoInforme;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void imprimir() {
        System.out.println(contenido);
    }
}
