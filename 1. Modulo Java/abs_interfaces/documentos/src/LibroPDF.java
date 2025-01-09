public class LibroPDF implements Imprimible{
    private int cantidadPaginas;
    private String autor;
    private String titulo;
    private String genero;
    public LibroPDF(int paginas, String autor, String titulo, String genero){
        this.titulo = titulo;
        this.cantidadPaginas = paginas;
        this.autor = autor;
        this.genero = genero;
    }
    @Override
    public void Imprimir() {
        System.out.printf("Titulo: %s, Autor: %s, Genero: %s, Cantidad de Paginas: %s\n", titulo, autor, genero, cantidadPaginas);
    }
    
}
