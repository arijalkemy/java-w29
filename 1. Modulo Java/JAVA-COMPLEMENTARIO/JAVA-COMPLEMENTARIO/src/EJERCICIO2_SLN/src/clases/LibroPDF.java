package src.clases;

public class LibroPDF extends Documento{

    private String genero;
    private int cantPaginas;
    private String autor;
    private String titulo;

    public LibroPDF(String genero, int cantPaginas, String autor, String titulo) {
        this.genero = genero;
        this.cantPaginas = cantPaginas;
        this.autor = autor;
        this.titulo = titulo;
    }

    @Override
    public void imprimir() {
        imprimirTipoDoc(); // Utiliza este metodo ya que la clase Curriculum extiende de Documento
        System.out.println("Titulo: " + titulo.toUpperCase());
        System.out.println("Autor: " + autor);
        System.out.println("Genero: " + genero);
    }
}
