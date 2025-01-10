package org.example.clases;

import org.example.interfaz.Carnivoro;

public class Perro extends Animal implements Carnivoro {
    public Perro() {
    }

    @Override
    public void emitirSonido() {
        System.out.println("Guauu");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comer carne");
    }
}
