package org.bootcamp;

public class Gato extends Animal implements Carnivoro {

    @Override
    public void emitirSonido() {
        System.out.println("Miua!");
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato como carne");
    }
}
