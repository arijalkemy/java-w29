package org.example.model;

public class Perro extends Animals implements Carnivoro{

    public Perro() {
        setSound("guau");
    }

    @Override
    public void makeSound() {
        System.out.println("Soy un perro y hago: " + getSound());
    }

    @Override
    public void comerCarne() {
        System.out.println("Soy un perro y como carne");
    }
}
