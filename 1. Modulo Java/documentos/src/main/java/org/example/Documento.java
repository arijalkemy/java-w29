package org.example;

public interface Documento {
    static void verDocumento(Documento documento){
        documento.imprimir();
    };

    void imprimir();
}
