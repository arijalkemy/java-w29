package org.example;

import org.example.entidades.Animal;
import org.example.entidades.Gato;
import org.example.entidades.Perro;
import org.example.entidades.Vaca;

public class Main {
    public static void main(String[] args) {
        Animal perro = new Perro();
        Animal gato = new Gato();
        Animal vaca = new Vaca();

        perro.emitirSonido();
        gato.emitirSonido();
        vaca.emitirSonido();

        comerAnimal(perro);
        comerAnimal(gato);
        comerAnimal(vaca);
    }

    private static void comerAnimal(Animal animal) {
        animal.comer();
    }
}