package org.example;

import org.example.fauna.Gato;
import org.example.fauna.Perro;
import org.example.fauna.Vaca;

public class Main {
    public static void main(String[] args) {
        Vaca vaca = new Vaca();
        Gato gato = new Gato();
        Perro perro = new Perro();

        System.out.println(vaca.comer());
        System.out.println(gato.comer());
        System.out.println(perro.comer());
        System.out.println("-----------------------");
        System.out.println(perro.comerAnimal(gato));
        System.out.println(gato.comerAnimal(vaca));
    }
}