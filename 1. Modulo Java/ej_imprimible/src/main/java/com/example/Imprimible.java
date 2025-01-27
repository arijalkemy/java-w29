package com.example;

public interface Imprimible {
    static void imprimir(Documento documento) {
        documento.imprimir();
    }

    void imprimirTipoDoc();
}
