package org.example.clases;

import org.example.interfaz.Herviboro;

public class Vaca extends Animal implements Herviboro {
    public Vaca() {
    }

    @Override
    public void emitirSonido() {
        System.out.println("Muuu");
    }


    @Override
    public void comerHierba() {
        System.out.println("Come hierbas.");
    }
}
