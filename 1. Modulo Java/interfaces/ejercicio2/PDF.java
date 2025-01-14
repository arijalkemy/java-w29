package ejercicio2;

public class PDF implements Documentos{
    public Integer Paginas;
    public String NombreAutor;
    public String Titulo;
    public String Genero;

    @Override
    public String imprimir() {
        return (Titulo + ", " + Genero + ", " + NombreAutor + ", " + Paginas + "Páginas");
    }

    public PDF(String genero, String nombreAutor, Integer paginas, String titulo) {
        Genero = genero;
        NombreAutor = nombreAutor;
        Paginas = paginas;
        Titulo = titulo;
    }
}
