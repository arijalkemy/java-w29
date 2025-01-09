package org.meli.models;

import org.meli.interfaces.Carnivoro;

public class Perro extends Animal implements Carnivoro {
    public Perro(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonido() {
        System.out.println(getNombre() + " Guau");
    }

    @Override
    public void comerCarne() {
        System.out.println(getNombre() + " está comiendo carne.");
    }
}
