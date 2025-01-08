package org.ejercicio2;

public interface Imprimible {

    static void imprimir(Documento documento) {
        documento.imprimir();
    }

    public String imprimirTipoDocumento();
}