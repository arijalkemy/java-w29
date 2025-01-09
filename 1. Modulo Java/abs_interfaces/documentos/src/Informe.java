public class Informe implements Imprimible{
    private String texto;
    private int cantidadPaginas;
    private String autor;
    private String revisor;
    public Informe(String autor, String revisor, int cantidadPaginas, String texto){
        this.texto = texto;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }
    @Override
    public void Imprimir() {
        System.out.printf("Autor: %s, Revisor: %s, cantidad de paginas: %s.\nTexto: %s", autor, revisor, cantidadPaginas, texto);
    }
}
