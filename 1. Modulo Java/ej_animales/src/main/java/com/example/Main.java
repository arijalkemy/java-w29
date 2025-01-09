package com.example;

import com.example.clases.Animal;
import com.example.clases.Gato;
import com.example.clases.Perro;
import com.example.clases.Vaca;
import com.example.interfaces.Carnivoro;
import com.example.interfaces.Herviboro;

public class Main {

    public static void comerAnimal(Animal animal) {
        if (animal instanceof Carnivoro){
            ((Carnivoro) animal).comerCarne();
        }
        else if (animal instanceof Herviboro) {
            ((Herviboro) animal).comerHierba();
        }
    }

    public static void main(String[] args) {
        Gato gato = new Gato();
        Perro perro = new Perro();
        Vaca vaca = new Vaca();

        gato.emitirSonido();
        perro.emitirSonido();
        vaca.emitirSonido();

        comerAnimal(gato);
        comerAnimal(perro);
        comerAnimal(vaca);
    }
}
