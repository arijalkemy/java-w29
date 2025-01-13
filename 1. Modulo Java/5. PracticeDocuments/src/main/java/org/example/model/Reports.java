package org.example.model;

import org.example.interfaces.IPrintable;

public class Reports implements IPrintable {

    /**
     * Attributes
     */
    private String author;
    private String reviser;
    public int numberOfPages;
    public String text;

    /**
     * Constructor
     */
    public Reports(String author, String reviser, int numberOfPages, String text) {
        this.author = author;
        this.reviser = reviser;
        this.numberOfPages = numberOfPages;
        this.text = text;
    }

    /**
     * Getters and Setters
     */
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReviser() {
        return reviser;
    }

    public void setReviser(String reviser) {
        this.reviser = reviser;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Informes -- \n" +
                "Autor: " + author + '\n' +
                "Revisor: " + reviser + '\n' +
                "Número de páginas: " + numberOfPages + '\n' +
                "Texto: " + text + '\n';
    }

    @Override
    public void print(Object document) {
        System.out.println(((Reports) document).toString());
    }
}

