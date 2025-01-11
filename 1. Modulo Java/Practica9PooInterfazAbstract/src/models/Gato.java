package models;

import interfaces.Carnivoro;

public class Gato extends Animal implements Carnivoro {
    @Override
    public void comerCarne() {
        System.out.println("El Gato come carne");
    }

    @Override
    public void emitirSonido() {
        System.out.println("El gato hace miau!");
    }
}
