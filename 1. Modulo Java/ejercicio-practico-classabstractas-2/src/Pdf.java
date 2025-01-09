public class Pdf implements Imprimible {
    private int cantPaginas;
    private String nombreAutor;
    private String titulo;
    private String genero;

    public Pdf(int cantPaginas, String nombreAutor, String titulo, String genero) {
        this.cantPaginas = cantPaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    public void imprimirDoc() {
        System.out.println("Nombre Autor: " + nombreAutor + " titulo: " + titulo + " genero: " + genero + " cant paginas: " + cantPaginas);
    }
}
