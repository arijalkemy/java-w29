package org.example.entidades;

import org.example.interfaces.Carnivoro;

public class Perro extends Animal implements Carnivoro {

    @Override
    public void emitirSonido() {
        System.out.println("GUAUUU");
    }

    @Override
    public void comer() {
        comerCarne();
    }
}
