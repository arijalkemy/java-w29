package classes;

import interfaces.Carnivorous;

public class Perro extends Animal implements Carnivorous {
    @Override
    public void makeSound() {
        System.out.println("Guau!");
    }

    @Override
    public void eatMeat() {
        System.out.println("Eating meat!");
    }

    @Override
    public void eat() {
        eatMeat();
    }
}
