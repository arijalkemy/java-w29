package org.example.clases;

import org.example.interfaz.Carnivoro;

public class Gato extends Animal implements Carnivoro {
    public Gato() {
    }

    @Override
    public void emitirSonido(){
        System.out.println("Miauu");
    }

    @Override
    public void comerCarne() {
        System.out.println("Come carne.");

    }
}
