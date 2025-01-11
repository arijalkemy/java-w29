package org.example.Ejercicio3;

public class Main {
    public static void main(String[] args) {
        Animal perro = new Perro();
        Animal gato = new Gato();
        Animal vaca = new Vaca();

        // Emitir sonidos
        System.out.println("Sonidos de los animales");
        perro.emitirSonido();
        gato.emitirSonido();
        vaca.emitirSonido();
        System.out.println("------------------------");
        // Comportamiento de alimentación
        System.out.println("Comportamiento alimentacion");
        comerAnimal(perro);
        comerAnimal(gato);
        comerAnimal(vaca);
    }

    public static void comerAnimal(Animal animal) {
        if (animal instanceof Carnivoro) {
            ((Carnivoro) animal).comerCarne();
        } else if (animal instanceof Herviboro) {
            ((Herviboro) animal).comerHierba();
        } else {
            System.out.println("El animal no puede comer.");
        }
    }
}