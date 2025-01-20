package org.example.poo.part2;

public class Vaca extends Animal implements Herbivoro {
    @Override
    void emitirSonido() {
        System.out.println("muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca está comiendo hierba");
    }
}
