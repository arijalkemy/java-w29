package org.example.model;

public class Vaca extends Animals implements Herviboro{

    public Vaca() {
        setSound("muuu");
    }

    @Override
    public void makeSound() {
        System.out.println("Soy una vaca y hago: " + getSound());
    }

    @Override
    public void comerHierba() {
        System.out.println("Soy una vaca y como hierba");
    }
}
