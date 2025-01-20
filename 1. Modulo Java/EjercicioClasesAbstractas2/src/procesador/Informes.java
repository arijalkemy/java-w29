package procesador;

public class Informes  implements Imprimible {

    private String texto;
    private Integer cantidadDePaginas;
    private String autor;
    private String revisor;

    public Informes(String texto, Integer cantidadDePaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Integer getCantidadDePaginas() {
        return cantidadDePaginas;
    }

    public void setCantidadDePaginas(Integer cantidadDePaginas) {
        this.cantidadDePaginas = cantidadDePaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    @Override
    public void imprimir() {
        System.out.println("Autor" + getAutor());
        System.out.println("Revisor" + getRevisor());
        System.out.println("Texto" + getTexto());
        System.out.println("Cantidad de Paginas" + getCantidadDePaginas());
    }
}
