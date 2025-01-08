package org.ejercicio3;

public class Gato extends Animal implements Carnivoro, Herviboro {
    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Come carne en trozos pequeños");
    }

    @Override
    public void comerHierba() {
        System.out.println("Come hierba en trozos pequeños");
    }

    @Override
    public String toString() {
        return "Gato";
    }
}
