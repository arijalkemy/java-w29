package classes;

import interfaces.Carnivorous;

public class Gato extends Animal implements Carnivorous {
    @Override
    public void makeSound() {
        System.out.println("Miau!");
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
