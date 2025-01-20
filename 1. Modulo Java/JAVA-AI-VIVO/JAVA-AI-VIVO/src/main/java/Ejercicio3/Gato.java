package Ejercicio3;

import Ejercicio3.Interfaces.Carnivoro;

class Gato extends Animal implements Carnivoro {
    public Gato(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonido() {
        System.out.println(getNombre() + " dice: ¡Miau!");
    }

    @Override
    public void comerCarne() {
        System.out.println(getNombre() + " está comiendo carne.");
    }
}
