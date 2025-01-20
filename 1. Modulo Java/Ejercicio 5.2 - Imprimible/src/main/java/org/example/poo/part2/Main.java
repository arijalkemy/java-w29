package org.example.poo.part2;

import static org.example.poo.part2.Animal.comerAnimal;

public class Main {
    public static void main(String[] args) {

        Perro dobby = new Perro();
        Gato garfield = new Gato();
        Vaca margarita = new Vaca();

        System.out.println("\n==== Perro ====");
        dobby.emitirSonido();
        dobby.comerCarne();

        System.out.println("\n==== Gato ====");
        garfield.emitirSonido();
        garfield.comerCarne();

        System.out.println("\n==== Vaca ====");
        margarita.emitirSonido();
        margarita.comerHierba();

        System.out.println("\n==== Probando comerAnimal ====");
        comerAnimal(garfield);
    }
}