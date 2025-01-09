package com.thiagoschreck.local.documentos;

public abstract class Documento implements Imprimible {
    private final String contenido;

    public Documento(String contenido) {
        this.contenido = contenido;
    }

    public void imprimir() {
        System.out.println(contenido);
    }
}
