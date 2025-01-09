package ej3;

public class Main {
    public static void main(String[] args) {
        Animal perro = new Perro();
        Animal gato = new Gato();
        Animal vaca = new Vaca();

        perro.emitirSonido();
        gato.emitirSonido();
        vaca.emitirSonido();

        comerAnimal(perro);
        comerAnimal(gato);
        comerAnimal(vaca);
    }

    private static void comerAnimal(Animal animal) {
        animal.comer();
    }
}
