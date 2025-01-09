package clases;

import interfaces.Herviboro;

public class Vaca extends Animal implements Herviboro {

    @Override
    public void emitirSonido() {
        System.out.println("Muu");
    }

    @Override
    public void comerHierba() {

    }

}
