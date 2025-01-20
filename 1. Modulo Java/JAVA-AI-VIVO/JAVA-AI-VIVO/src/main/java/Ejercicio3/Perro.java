package Ejercicio3;

import Ejercicio3.Interfaces.Carnivoro;

// Clase Perro
class Perro extends Animal implements Carnivoro {
    public Perro(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonido() {
        System.out.println(getNombre() + " dice: ¡Guau!");
    }

    @Override
    public void comerCarne() {
        System.out.println(getNombre() + " está comiendo carne.");
    }
}
