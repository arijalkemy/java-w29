package org.example;

public interface Imprimible {

    static void imprimirDocumento(Imprimible documento) {
        documento.imprimir();
    }

    void imprimir();
}
