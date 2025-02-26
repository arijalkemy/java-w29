package com.animal.animales;

public class Perro extends Animal implements Carnivoro {

    @Override
    public void emitirSonidos() {
        System.out.println("Guau");
        this.comiendo();
    }

}