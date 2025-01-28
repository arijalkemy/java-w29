package com.example;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Libro extends Documento {

    private final int cantidadPaginas;

    private final String autor;

    private final String titulo;

    private final String genero;

    @Override
    public void imprimir() {
        imprimirTipoDoc();

        System.out.println(this);
    }
}