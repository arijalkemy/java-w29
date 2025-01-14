package org.example;

public class Gato extends Animal implements Carnivoro{

    @Override
    public void emitirSonido() {
        System.out.println("Miauu");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comer carne");
    }
}
