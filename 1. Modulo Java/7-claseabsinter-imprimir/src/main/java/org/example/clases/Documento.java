package org.example.clases;

import org.example.interfaces.Imprimir;

public abstract  class Documento implements Imprimir {
    public Documento() {
    }

    //implementar un metodo abstracto
    public void imprimir() {}

    @Override
    public void imprimirTipoDoc(){
        System.out.println("-----------El tipo de documento es :" + getClass().getSimpleName().toUpperCase() + " ------------");

    }
}
