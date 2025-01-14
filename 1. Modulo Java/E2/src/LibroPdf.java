public class LibroPdf implements Imprimir{
    private int paginas;
    private String autor;
    private String titulo;
    private String genero;

    public LibroPdf(int paginas, String autor, String titulo, String genero) {
        this.paginas = paginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println("Libro PDF:");
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Pagina: " + paginas);
        System.out.println("Genero: " + genero + "\n");
    }

}
