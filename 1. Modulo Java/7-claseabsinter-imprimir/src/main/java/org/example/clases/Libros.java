package org.example.clases;
//Incluyen atributos como cantidad de páginas, nombre del autor, título y género.
public class Libros extends Documento{
    private String titulo;
    private String autor;
    private int cantPag;
    private String genero;

    //constructor
    public Libros(String titulo, String autor, int cantPag, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.cantPag = cantPag;
        this.genero = genero;
    }

    //getters y setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCantPag() {
        return cantPag;
    }

    public void setCantPag(int cantPag) {
        this.cantPag = cantPag;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    //implementar metodo imprimir
    @Override
    public void imprimir() {
        imprimirTipoDoc();
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("CantPag: " + cantPag);
        System.out.println("Genero: " + genero);
    }
}
