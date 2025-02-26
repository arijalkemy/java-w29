package com.javadocum.documentos;

public interface Imprimible {
    static void imprimir(Documento documento) {
        documento.imprimir();
    }
}
