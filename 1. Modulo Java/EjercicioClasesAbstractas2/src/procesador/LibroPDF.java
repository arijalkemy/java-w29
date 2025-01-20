package procesador;

public class LibroPDF implements Imprimible {

    private Integer cantidadDePaginas;
    private String nombreAutor;
    private String titulo;
    private String genero;

    public LibroPDF(Integer cantidadDePaginas, String nombreAutor, String titulo, String genero) {
        this.cantidadDePaginas = cantidadDePaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    public Integer getCantidadDePaginas() {
        return cantidadDePaginas;
    }

    public void setCantidadDePaginas(Integer cantidadDePaginas) {
        this.cantidadDePaginas = cantidadDePaginas;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println("Nombre Autor: " + getNombreAutor());
        System.out.println("Titulo: " + getTitulo());
        System.out.println("Genero: " + getGenero());
        System.out.println("Cantidad de Paginas: " + getCantidadDePaginas());
    }
}
