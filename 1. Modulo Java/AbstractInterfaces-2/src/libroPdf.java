public class libroPdf implements Imprimible{

    //Incluyen atributos como cantidad de páginas, nombre del autor, título y género.

    private Integer cantPaginas;
    private String autor;
    private String titulo;
    private String genero;

    public libroPdf(Integer cantPaginas, String autor, String titulo, String genero) {
        this.cantPaginas = cantPaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    public Integer getCantPaginas() {
        return cantPaginas;
    }

    public void setCantPaginas(Integer cantPaginas) {
        this.cantPaginas = cantPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
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
        System.out.println("Libro PDF:");
        System.out.println("Autor: " + autor);
        System.out.println("Título: " + titulo);
        System.out.println("Género: " + genero);
        System.out.println("Cantidad de páginas: " + cantPaginas);
    }
}
