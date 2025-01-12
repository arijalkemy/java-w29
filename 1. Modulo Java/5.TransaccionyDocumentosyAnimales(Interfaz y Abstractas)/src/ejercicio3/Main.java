package ejercicio3;

import ejercicio3.Animales.Animal;
import ejercicio3.Animales.Gato;
import ejercicio3.Animales.Perro;
import ejercicio3.Animales.Vaca;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Vaca vaca = new Vaca();
        Gato gato = new Gato();
        Perro perro = new Perro();

        comerAnimal(vaca);
        comerAnimal(gato);
        comerAnimal(perro);

    }

    public static void comerAnimal(Animal animal) {
        animal.comer();
        animal.emitirSonido();
    }

}