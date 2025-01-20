package Ejercicio3;

import Ejercicio3.Interfaces.Herviboro;

class Vaca extends Animal implements Herviboro {
    public Vaca(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonido() {
        System.out.println(getNombre() + " dice: ¡Muuu!");
    }

    @Override
    public void comerHierba() {
        System.out.println(getNombre() + " está comiendo hierba.");
    }
}
