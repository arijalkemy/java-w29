package ejercicio3.Animales;

import ejercicio3.alimenticios.Carnivoro;
import ejercicio3.alimenticios.Herviboro;

public class Gato extends Animal implements Carnivoro, Herviboro {
    @Override
    public void emitirSonido() {
        System.out.println("Miau Miau");
    }

    @Override
    public void comer() {
        System.out.println("Gato: ");
        comerCarne();
    }

}
