package Ex2;

public class ArchivoPDF{

    private String nombreAutor;
    private Integer cantPaginas;
    private String titulo;

    public ArchivoPDF(String nombreAutor, Integer cantPaginas, String titulo) {
        this.nombreAutor = nombreAutor;
        this.cantPaginas = cantPaginas;
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "ArchivoPDF{" +
                "nombreAutor='" + nombreAutor + '\'' +
                ", cantPaginas=" + cantPaginas +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
