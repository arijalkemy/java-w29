package org.example.poo.part2;

public class Perro extends Animal implements Carnivoro {
    @Override
    void emitirSonido() {
        System.out.println("guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro está comiendo carne");
    }
}
