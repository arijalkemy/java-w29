package com.example.demo.abstractClass.ej_2;

public interface Imprimible {
    static void imprimir(Imprimible documento) {
        System.out.println(documento.obtenerContenido());
    }

    String obtenerContenido();
}
