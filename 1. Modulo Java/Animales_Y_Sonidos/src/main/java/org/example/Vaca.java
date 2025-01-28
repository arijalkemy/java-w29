package org.example;

class Vaca extends Animal implements Comer {
    public void emitirSonido() {
        System.out.println("La vaca dice: muuu");
    }

    public void comer() {
        System.out.println("La vaca come hierba.");
    }
}
