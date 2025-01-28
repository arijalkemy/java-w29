package org.example;

class Perro extends Animal implements Comer {
    public void emitirSonido() {
        System.out.println("El perro dice: guau");
    }

    public void comer() {
        System.out.println("El perro come carne.");
    }
}
