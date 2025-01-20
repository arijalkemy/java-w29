package Ex3.Clases;

import Ex3.Interfaces.Carnivoro;

public class Perro extends Animal implements Carnivoro {
    public Perro() {

    }
    public Perro(String nombre) {this.name = nombre;}

    @Override
    public void sonido() {
        System.out.println("Guau!");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne");
    }
}
