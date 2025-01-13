package com.exercise3;

public class Perro extends Animal implements Carnivoro {

    @Override
    public void emitirSonidos() {
        System.out.println("Guau");
        this.comiendo();
    }

}
