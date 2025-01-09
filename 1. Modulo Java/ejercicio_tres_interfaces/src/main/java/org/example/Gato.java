package org.example;

public class Gato extends Animal implements Carnivoro{
    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comer() {
        comerCarne();
    }
}
