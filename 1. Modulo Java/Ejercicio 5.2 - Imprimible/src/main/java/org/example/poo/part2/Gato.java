package org.example.poo.part2;

public class Gato extends Animal implements Carnivoro{
    @Override
    void emitirSonido() {
        System.out.println("miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato está comiendo carne");
    }
}
