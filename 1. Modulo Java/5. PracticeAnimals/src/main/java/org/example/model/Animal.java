package org.example.model;

import org.example.interfaces.IEatingModes;

public abstract class Animal implements IEatingModes {
    public Animal() {
    }

    public abstract void makeSound();

    @Override
    public void eatAnimal(Object animal) {
        if (animal instanceof Dog) {
            eatMeat();
        } else if (animal instanceof Cat) {
            eatMeat();
        } else if (animal instanceof Cow) {
            eatGrass();
        }
    }

    @Override
    public void eatGrass() {
        System.out.println("Comiendo hierba");
    }

    @Override
    public void eatMeat() {
        System.out.println("Comiendo carne");
    }
}
