package org.bootcamp;

public class Vaca extends Animal implements Herviboro {

    @Override
    public void emitirSonido() {
        System.out.println("Muuuu!");
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca come pasto!");
    }
}
