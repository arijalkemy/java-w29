package models;

import interfaces.Herviboro;

public class Vaca extends Animal implements Herviboro {
    @Override
    public void comerHierba() {
        System.out.println("La vaca como hierba");
    }

    @Override
    public void emitirSonido(){
        System.out.println("La vaca hace muu!");
    }
}
