package org.example.entidades;

import org.example.interfaces.Hervivoro;

public class Vaca extends Animal implements Hervivoro {
    @Override
    public void emitirSonido() {
        System.out.println("MUUUU");
    }

    @Override
    public void comer() {
        comerHierba();
    }
}
