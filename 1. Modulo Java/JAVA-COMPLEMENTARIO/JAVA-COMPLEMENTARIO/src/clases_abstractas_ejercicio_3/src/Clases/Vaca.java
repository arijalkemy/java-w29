package Clases;

import Interfaces.Herviboro;

public class Vaca extends Animal implements Herviboro {

    @Override
    public void emitirSonido() {
        System.out.println("Muu");
    }

    @Override
    public String comerHierba() {
        return "Muu delicioso";
    }

}
