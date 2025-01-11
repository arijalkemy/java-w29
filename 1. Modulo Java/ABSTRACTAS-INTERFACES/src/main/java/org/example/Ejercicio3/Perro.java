package org.example.Ejercicio3;

public class Perro extends Animal implements Carnivoro {


    @Override
    public void emitirSonido() {
        System.out.println("El perro hace guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro come carne");

    }
}
