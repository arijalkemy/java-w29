package Ejercicio2;

public class LibroPDF {
    private String titulo;
    private String autor;
    private String genero;
    private int paginas;

    public LibroPDF(String titulo, String autor, String genero, int paginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.paginas = paginas;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public int getPaginas() {
        return paginas;
    }
}

