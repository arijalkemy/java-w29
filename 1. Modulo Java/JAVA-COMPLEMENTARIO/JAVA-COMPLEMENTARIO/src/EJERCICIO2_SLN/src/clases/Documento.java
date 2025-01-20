package src.clases;

import src.interfaces.Imprimible;

// La clase abstracta Documento, implementa la interfaz Imprimible
public abstract class Documento implements Imprimible {

    //Una clase abstracta al menos debe contener un método abstracto.
    public abstract void imprimir();

    //Se redefine el metodo imprimirTipoDoc que corresponde a la interfaz Imprimible
    @Override
    public void imprimirTipoDoc(){
        System.out.println("----------- " + getClass().getSimpleName().toUpperCase() + " ------------");
    }
}
