package ejercicio_3;

public class Main {
    public static void main(String[] args) {
        Gato gato = new Gato();
        Perro perro = new Perro();
        Vaca vaca = new Vaca();

        gato.emitirSonido();
        perro.emitirSonido();
        vaca.emitirSonido();

        AlimentacionManager.comerAnimal(gato);
        AlimentacionManager.comerAnimal(perro);
        AlimentacionManager.comerAnimal(vaca);
    }
}
