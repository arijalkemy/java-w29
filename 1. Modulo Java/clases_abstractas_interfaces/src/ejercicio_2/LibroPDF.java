package ejercicio_2;

public class LibroPDF implements Imprimible {
    private int cantidadPaginas;
    private String titulo;
    private String autor;
    private String genero;

    public LibroPDF(int cantidadPaginas, String titulo, String autor, String genero) {
        this.cantidadPaginas = cantidadPaginas;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimindo libro pdf");
        System.out.println("Cantidad de Paginas: " + cantidadPaginas);
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Genero: " + genero);
    }
}
