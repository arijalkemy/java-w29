package org.example.Ejercicio3;

public class Vaca extends Animal implements Herviboro {
    @Override
    public void emitirSonido() {
        System.out.println("La vaca hace Muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca come hierba");

    }

}
