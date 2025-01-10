package ejercicio_2;

public class Informe implements Imprimible{
    private int longitud;
    private int cantidadPaginas;
    private String autor;
    private String revisor;

    public Informe(int longitud, int cantidadPaginas, String autor, String revisor) {
        this.longitud = longitud;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo informe");
        System.out.println("Longitud: " + longitud);
        System.out.println("Cantidad Paginas: " + cantidadPaginas);
        System.out.println("Autor: " + autor);
        System.out.println("Revisor: " + revisor);
    }
}
