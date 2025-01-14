package ejercicio2;

public class Informe implements Documentos{
    public Integer Longitud;
    public String Autor;
    public Integer Paginas;
    public String Revisor;

    @Override
    public String imprimir() {
        return (Longitud + "Palabras, " + Paginas + " Páginas, "+ "Hecho por: " + Autor + ", Revisado por: " + Revisor);
    }

    public Informe(String autor, String revisor, Integer longitud, Integer paginas) {
        Autor = autor;
        Revisor = revisor;
        Longitud = longitud;
        Paginas = paginas;
    }
}
