public class Informe implements Imprimible{
    //Incluyen un texto de n longitud, cantidad de páginas, autor, y revisor.
    private String texto;
    private Integer cantPaginas;
    private String autor;
    private String revisor;

    public Informe(String texto, Integer cantPaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantPaginas = cantPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
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

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    @Override
    public void imprimir() {
        System.out.println("Informe:");
        System.out.println("Texto: " + texto);
        System.out.println("Cantidad de páginas: " + cantPaginas);
        System.out.println("Autor: " + autor);
        System.out.println("Revisor: " + revisor);
    }
}
