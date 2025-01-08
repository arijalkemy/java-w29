package org.ejercicio3;

public class Perro extends Animal implements Carnivoro, Herviboro {

    @Override
    public void emitirSonido() {
        System.out.println("Guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Come carne en trozos grandes");
    }

    @Override
    public void comerHierba() {
        System.out.println("Come hierba en trozos grandes");
    }

    @Override
    public String toString() {
        return "Perro";
    }
}
