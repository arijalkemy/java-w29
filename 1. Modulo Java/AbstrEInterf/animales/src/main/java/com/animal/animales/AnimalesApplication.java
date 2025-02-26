package com.animal.animales;

public final class AnimalesApplication {
    private AnimalesApplication() {
    }

    public static void main(String[] args) {
        Animal vaca = new Vaca();
        Animal perro = new Perro();
        Animal gato = new Gato();

        vaca.emitirSonidos();

        perro.emitirSonidos();

        gato.emitirSonidos();

        Animal.comerAnimal(vaca);

        Animal.comerAnimal(perro);

        Animal.comerAnimal(gato);
    }
}
