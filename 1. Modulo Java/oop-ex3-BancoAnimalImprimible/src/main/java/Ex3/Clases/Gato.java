package Ex3.Clases;

import Ex3.Interfaces.Carnivoro;

public class Gato extends Animal implements Carnivoro {

    public Gato(String name) {
    this.name = name;
    }

    @Override
    public void sonido() {
        System.out.println("Miuu!");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo Atun");
    }
}
