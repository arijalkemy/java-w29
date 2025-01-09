package org.example;

public abstract class Documento implements Imprimible {
    protected String autor;

    public Documento(String autor) {
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }
}

