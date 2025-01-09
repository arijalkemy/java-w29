package com.example;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class Informe extends Documento {

    private final String texto;

    private final int cantidadPaginas;

    private final String autor;

    private final String revisor;

    @Override
    public void imprimir() {
        imprimirTipoDoc();

        System.out.println(toString());
    }

}

