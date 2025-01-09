package clases;

public class LibroPDF extends Documento{

    private String genero;
    private Integer paginas;
    private String autor;
    private String titulo;

    public LibroPDF(String genero, Integer paginas, String autor, String titulo) {
        this.genero = genero;
        this.paginas = paginas;
        this.autor = autor;
        this.titulo = titulo;
    }

    @Override
    public void imprimir() {
        System.out.println("Titulo: " + titulo.toUpperCase());
        System.out.println("Autor: " + autor);
        System.out.println("Genero: " + genero);
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
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
}
