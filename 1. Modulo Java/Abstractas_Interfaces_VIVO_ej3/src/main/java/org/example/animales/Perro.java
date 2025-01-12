package org.example.animales;

import org.example.abstracta.Animal;
import org.example.interfaces.Carnivoro;

public class Perro extends Animal implements Carnivoro {



    @Override
    public void emitirSonido() {
        System.out.println("¡Guau!");
    }

    @Override
    public String comerCarne() {
        return "Comiendo pollo";
    }
}
