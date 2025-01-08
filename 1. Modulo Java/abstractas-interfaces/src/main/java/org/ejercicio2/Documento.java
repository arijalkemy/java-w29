package org.ejercicio2;

public abstract class Documento implements Imprimible {
    public abstract void imprimir();

    @Override
    public String imprimirTipoDocumento(){
        return getClass().getSimpleName().toUpperCase();
    }
}
