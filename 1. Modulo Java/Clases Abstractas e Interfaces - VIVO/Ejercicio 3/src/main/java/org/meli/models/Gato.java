package org.meli.models;

import org.meli.interfaces.Carnivoro;

public class Gato extends Animal implements Carnivoro {
    public Gato(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonido() {
        System.out.println(getNombre() + " Miau");
    }

    @Override
    public void comerCarne() {
        System.out.println(getNombre() + " está comiendo carne.");
    }
}
