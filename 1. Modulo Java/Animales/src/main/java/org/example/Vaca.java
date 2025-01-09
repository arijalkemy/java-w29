package org.example;

public class Vaca extends Animal implements Herbivoro{
    @Override
    public void emitirSonido() {
        System.out.println("Muuu");
    }

    @Override
    public void comerHierva() {
        System.out.println("La vaca esta comiendo hierva");
    }
}
