package com.exercise3;

public class Gato extends Animal implements Carnivoro {

    @Override
    public void emitirSonidos() {
        System.out.println("miuau");
        this.comiendo();
    }

}
