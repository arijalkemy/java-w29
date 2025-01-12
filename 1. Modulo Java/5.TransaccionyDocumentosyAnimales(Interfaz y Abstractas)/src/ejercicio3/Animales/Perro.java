package ejercicio3.Animales;

import ejercicio3.alimenticios.Carnivoro;

public class Perro extends Animal implements Carnivoro {

    @Override
    public void emitirSonido() {
        System.out.println("Guau Guau");
    }

    @Override
    public void comer() {
        System.out.println("Perro: ");
        comerCarne();
    }


}
