package org.meli.models;

import org.meli.interfaces.Herbivoro;

public class Vaca extends Animal implements Herbivoro {
    public Vaca(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonido() {
        System.out.println(getNombre() + " Muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println(getNombre() + " está comiendo hierba.");
    }
}
