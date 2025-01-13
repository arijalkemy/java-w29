public class Main {
    public static void main(String[] args) {

        Vaca vaca = new Vaca();
        vaca.emitirSonido();
        Perro perro = new Perro();
        perro.emitirSonido();
        Gato gato = new Gato();
        gato.emitirSonido();
        comerAnimal(vaca);

    }

    public static void comerAnimal(Animal animal) {
        animal.animalComer();
    }

}