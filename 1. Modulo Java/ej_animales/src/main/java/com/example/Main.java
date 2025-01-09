package com.example;

import com.example.clientes.Animal;
import com.example.clientes.Gato;
import com.example.clientes.Perro;
import com.example.clientes.Vaca;
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
