package Ejercicio2;

public class Informe {
    private String texto;
    private String autor;
    private String revisor;
    private int paginas;

    public Informe(String texto, String autor, String revisor, int paginas) {
        this.texto = texto;
        this.autor = autor;
        this.revisor = revisor;
        this.paginas = paginas;
    }

    public String getTexto() {
        return texto;
    }

    public String getAutor() {
        return autor;
    }

    public String getRevisor() {
        return revisor;
    }

    public int getPaginas() {
        return paginas;
    }
}
