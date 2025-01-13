package org.example.model;

public class Gato extends Animals implements Carnivoro{

    public Gato() {
        setSound("miau");
    }

    @Override
    public void makeSound() {
        System.out.println("Soy un gato y hago: " + getSound());
    }

    @Override
    public void comerCarne() {
        System.out.println("Soy un gato y como carne");
    }
}
