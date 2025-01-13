package org.example.model;

import org.example.interfaces.IPrintable;

public class PdfBooks implements IPrintable {

    /**
     * Attributes
     */
    private String name;
    private String tittle;
    private String genre;
    private int numberOfPages;

    /**
     * Constructor
     */
    public PdfBooks(String name, String tittle, String genre, int numberOfPages) {
        this.name = name;
        this.tittle = tittle;
        this.genre = genre;
        this.numberOfPages = numberOfPages;
    }

    /**
     * Getters and Setters
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return "Libros en PDF -- \n" +
                "Nombre: " + name + '\n' +
                "Título: " + tittle + '\n' +
                "Gpenero: " + genre + '\n' +
                "Número de páginas: " + numberOfPages + '\n';
    }

    @Override
    public void print(Object document) {
        System.out.println(((PdfBooks) document).toString());
    }
}
