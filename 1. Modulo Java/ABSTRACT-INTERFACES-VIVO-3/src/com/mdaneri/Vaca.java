package com.mdaneri;

public class Vaca extends Animal implements Herbivoro {

    @Override
    public void emitirSonido() {
        System.out.println("muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca come hierba");
    }
}