package org.example.animales;

import org.example.abstracta.Animal;
import org.example.interfaces.Hervivoro;

public class Vaca extends Animal implements Hervivoro {
    @Override
    public String comerHierba(){
        return "Comiendo trigo";
    }
    @Override
    public void emitirSonido() {
        System.out.println("¡Muuuuu!");
    }
}
