package com.example;

public abstract class Documento implements Imprimible {
    public abstract void imprimir();

    @Override
    public void imprimirTipoDoc() {
        System.out.println(getClass().getSimpleName().toUpperCase());
    }
}
