package org.example;

public class Gato extends Animal implements Carnivoro{
    @java.lang.Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato esta comiendo carne");
    }
}
