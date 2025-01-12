package org.example.animales;

import org.example.abstracta.Animal;
import org.example.interfaces.Carnivoro;

public class Gato extends Animal implements Carnivoro {
    @Override
    public String comerCarne(){
        return "Comiendo atun";
    }
    @Override
    public void emitirSonido() {
        System.out.println("¡Miau!");
    }
}
