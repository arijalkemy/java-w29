package com.exercise3;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
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
