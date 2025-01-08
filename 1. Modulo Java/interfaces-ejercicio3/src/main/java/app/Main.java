package app;

import models.Animal;
import models.Gato;
import models.Perro;
import models.Vaca;

public class Main {
    public static void main(String[] args) {
        Animal vaca = new Vaca();
        Animal perro = new Perro();
        Animal gato = new Gato();

        vaca.emitirSonido();
        perro.emitirSonido();
        gato.emitirSonido();

        comerAnimal(vaca);
        comerAnimal(perro);
        comerAnimal(gato);
    }

    private static void comerAnimal(Animal animal) {
        animal.comer();
    }
}
