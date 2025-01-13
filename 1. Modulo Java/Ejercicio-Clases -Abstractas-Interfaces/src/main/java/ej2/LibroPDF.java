package ej2;

public class LibroPDF extends Documento{

    private int cantidadPaginas;
    private String nombreAutor;
    private String titulo;
    private String genero;

    public LibroPDF(int cantidadPaginas, String nombreAutor, String titulo, String genero) {
        super(
                "Libro PDF:\n paginas: " + cantidadPaginas
                + "\n nombre autor: " + nombreAutor
                + "\n titulo: " + titulo
                + "\n genero: " + genero
        );
        this.cantidadPaginas = cantidadPaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println(contenido);
    }
}
