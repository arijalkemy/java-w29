package org.example.entidades;

import org.example.interfaces.Carnivoro;

public class Gato extends Animal implements Carnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("MIAUUUU");
    }

    @Override
    public void comer() {
        comerCarne();
    }
}
