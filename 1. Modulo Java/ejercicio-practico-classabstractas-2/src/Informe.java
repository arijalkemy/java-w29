public class Informe implements Imprimible {
    private int longitud;
    private String autor;
    private String revisor;
    private int cantPaginas;

    public Informe(int longitud, String autor, String revisor, int cantPaginas) {
        this.longitud = longitud;
        this.autor = autor;
        this.revisor = revisor;
        this.cantPaginas = cantPaginas;
    }

    //Informes: Incluyen un texto de n longitud, cantidad de páginas, autor, y revisor.
    public void imprimirDoc() {
        System.out.println("Longitud: " + longitud + " autor: " + autor + " revisor: " + revisor + " cantPaginas: " + cantPaginas);
    }

}
