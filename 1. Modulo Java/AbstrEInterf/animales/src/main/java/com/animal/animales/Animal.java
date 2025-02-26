package com.animal.animales;

public abstract class Animal {
    public abstract void emitirSonidos();

    static void comerAnimal(Animal animal) {
        String type = animal.getClass().getInterfaces()[0].getName().replace("com.exercise3.", "");

        if (type.equals("Carnivoro")) {
            Carnivoro.comer();
        } else {
            Herbivoro.comer();
        }
    }

}