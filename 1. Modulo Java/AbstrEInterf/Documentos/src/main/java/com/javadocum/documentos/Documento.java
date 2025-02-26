package com.javadocum.documentos;

public abstract class Documento {
    public void imprimir() {
        System.out.println(this.toString());
    };

    public abstract String toString();
}