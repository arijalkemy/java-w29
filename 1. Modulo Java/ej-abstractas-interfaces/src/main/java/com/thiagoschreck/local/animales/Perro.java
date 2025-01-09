package com.thiagoschreck.local.animales;

public class Perro extends Animal implements Carnivoro {

    @Override
    public void emitirSonido() {
        System.out.println("guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro come carne");
    }
}
