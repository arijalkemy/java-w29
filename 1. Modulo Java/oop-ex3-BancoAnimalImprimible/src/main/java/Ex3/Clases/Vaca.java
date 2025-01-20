package Ex3.Clases;

import Ex3.Interfaces.Herviboro;

public class Vaca extends Animal implements Herviboro {
    public Vaca() {

    }

    public Vaca(String nombre) {this.name = nombre;}

    @Override
    public void sonido() {
        System.out.println("Muuu!");
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo pasto!");
    }
}
