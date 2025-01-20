package Ex2;

public class Informe {
    private String descripcion;
    private Integer cantPaginas;
    private String autor;
    private String revisor;

    public Informe(String descripcion, Integer cantPaginas, String autor, String revisor) {
        this.descripcion = descripcion;
        this.cantPaginas = cantPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return "Informe{" +
                "descripcion='" + descripcion + '\'' +
                ", cantPaginas=" + cantPaginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}';
    }
}
