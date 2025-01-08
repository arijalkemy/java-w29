package org.ejercicio3;

public class Vaca extends Animal implements Herviboro {
    @Override
    public void emitirSonido() {
        System.out.println("Muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Come hierba en trozos gigantes");
    }

    @Override
    public String toString() {
        return "Vaca";
    }
}
