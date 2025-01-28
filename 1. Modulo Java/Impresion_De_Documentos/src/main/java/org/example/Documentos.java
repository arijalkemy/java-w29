package org.example;

class Curriculum implements Imprimible {
    private String nombre;
    private String[] habilidades;

    public Curriculum(String nombre, String[] habilidades) {
        this.nombre = nombre;
        this.habilidades = habilidades;
    }

    public void imprimir() {
        System.out.println("Curriculum de: " + nombre);
        System.out.println("Habilidades: ");
        for (String habilidad : habilidades) {
            System.out.println("- " + habilidad);
        }
    }
}

class LibroPDF implements Imprimible {
    private String autor;
    private String titulo;
    private String genero;
    private int cantidadPaginas;

    public LibroPDF(String autor, String titulo, String genero, int cantidadPaginas) {
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
        this.cantidadPaginas = cantidadPaginas;
    }

    public void imprimir() {
        System.out.println("Libro PDF: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Género: " + genero);
        System.out.println("Páginas: " + cantidadPaginas);
    }
}

class Informe implements Imprimible {
    private String texto;
    private String autor;
    private String revisor;
    private int cantidadPaginas;

    public Informe(String texto, String autor, String revisor, int cantidadPaginas) {
        this.texto = texto;
        this.autor = autor;
        this.revisor = revisor;
        this.cantidadPaginas = cantidadPaginas;
    }

    public void imprimir() {
        System.out.println("Informe por: " + autor);
        System.out.println("Revisado por: " + revisor);
        System.out.println("Contenido: " + texto);
        System.out.println("Páginas: " + cantidadPaginas);
    }
}
