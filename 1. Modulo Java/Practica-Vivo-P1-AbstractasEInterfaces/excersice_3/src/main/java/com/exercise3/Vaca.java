package com.exercise3;

public class Vaca extends Animal implements Herbivoro {

    @Override
    public void emitirSonidos() {
        System.out.println("Muuuuu");
        this.comiendo();
    }

}
