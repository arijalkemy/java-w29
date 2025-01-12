package ejercicio3.Animales;

import ejercicio3.alimenticios.Herviboro;

public class Vaca extends Animal implements Herviboro {
    @Override
    public void emitirSonido() {
        System.out.println("Muu Muu");
    }

    @Override
    public void comer() {
        System.out.println("Vaca: ");
        comerHierba();
    }


}
