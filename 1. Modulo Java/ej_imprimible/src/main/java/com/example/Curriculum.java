package com.example;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Curriculum extends Documento {
    private final String nombre;

    private final String apellido;

    private final int edad;

    private final String[] habilidades;

    @Override
    public void imprimir() {
        imprimirTipoDoc();

        System.out.println(this);
    }
}