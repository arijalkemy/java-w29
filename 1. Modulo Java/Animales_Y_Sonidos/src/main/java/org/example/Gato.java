package org.example;

class Gato extends Animal implements Comer {
    public void emitirSonido() {
        System.out.println("El gato dice: miau");
    }

    public void comer() {
        System.out.println("El gato come carne.");
    }
}
