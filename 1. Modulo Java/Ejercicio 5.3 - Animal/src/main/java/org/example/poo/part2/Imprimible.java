package org.example.poo.part2;

public interface Imprimible {

    static void imprimir(Imprimible documento) {
        documento.imprimir();
    }
    void imprimir();
}
