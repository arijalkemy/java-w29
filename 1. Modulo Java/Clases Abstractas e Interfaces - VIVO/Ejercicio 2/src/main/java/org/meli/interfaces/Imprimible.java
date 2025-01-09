package org.meli.interfaces;

public interface Imprimible {
    String obtenerContenido();

    static void imprimir(Imprimible documento) {
        System.out.println("Imprimiendo Documento");
        System.out.println(documento.obtenerContenido());
        System.out.println("Fin del Documento\n");
    }
}
