package org.example;

import org.example.model.Cat;
import org.example.model.Cow;
import org.example.model.Dog;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        Cow cow = new Cow();

        cat.makeSound();
        cat.eatAnimal(cat);

        dog.makeSound();
        dog.eatAnimal(dog);

        cow.makeSound();
        cow.eatAnimal(cow);
    }
}