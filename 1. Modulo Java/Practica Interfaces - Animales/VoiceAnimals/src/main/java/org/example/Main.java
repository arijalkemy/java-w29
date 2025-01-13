package org.example;

import org.example.model.*;

public class Main {

    public static void comerAnimal (Animals animal){
        if(animal instanceof Carnivoro){
            ((Carnivoro) animal).comerCarne();
        }
        else if (animal instanceof  Herviboro){
            ((Herviboro) animal).comerHierba();
        }
    }

    public static void main(String[] args) {

        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        //Hacer sonidos
        System.out.println("Los animales hacen ruidos");
        perro.makeSound();
        gato.makeSound();
        vaca.makeSound();

        //Alimentar Animal
        System.out.println("Los animales se alimentan");
        comerAnimal(perro);
        comerAnimal(gato);
        comerAnimal(vaca);
    }
}