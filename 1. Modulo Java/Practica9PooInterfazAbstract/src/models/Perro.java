package models;

import interfaces.Carnivoro;

public class Perro extends Animal implements Carnivoro {
    @Override
    public void comerCarne() {
        System.out.println("El perro come carne");
    }

    @Override
    public void emitirSonido() {
        System.out.println("El perro hace guau!");
    }
}
