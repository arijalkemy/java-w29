package ejercicio2;

public class LibroPDF implements Imprimible{

    //Atributos
    private int cantidadPaginas;
    private String genero, autor, titulo;


    public LibroPDF(int cantidadPaginas, String genero, String autor, String titulo) {
        this.cantidadPaginas = cantidadPaginas;
        this.genero = genero;
        this.autor = autor;
        this.titulo = titulo;
    }

    @Override
    public void imprimir() {
        System.out.println("LibroPDF");
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "LibroPDF{" +
                "cantidadPaginas=" + cantidadPaginas +
                ", genero='" + genero + '\'' +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
