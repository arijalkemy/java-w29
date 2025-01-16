package classes;

import interfaces.Herbivorous;

public class Vaca extends Animal implements Herbivorous {
    @Override
    public void makeSound() {
        System.out.println("Muuu!");
    }

    @Override
    public void eatGrass() {
        System.out.println("Eating grass!");
    }

    @Override
    public void eat() {
        eatGrass();
    }
}
