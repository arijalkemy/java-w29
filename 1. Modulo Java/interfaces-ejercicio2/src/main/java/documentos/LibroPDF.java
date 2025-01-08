package documentos;

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

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String obtenerContenido() {
        return "LibroPDF{" +
                "cantidadPaginas=" + cantidadPaginas +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }

}
