package Ejercicio3;

import Ejercicio3.Interfaces.Carnivoro;
import Ejercicio3.Interfaces.Herviboro;

public class Main {
    public static void main(String[] args) {
        // Creación de animales
        Animal perro = new Perro("Rex");
        Animal gato = new Gato("Luna");
        Animal vaca = new Vaca("Margarita");

        // Invocar métodos específicos
        perro.emitirSonido();
        gato.emitirSonido();
        vaca.emitirSonido();

        // Método comerAnimal
        comerAnimal(perro);
        comerAnimal(gato);
        comerAnimal(vaca);
    }

    // Método comerAnimal
    public static void comerAnimal(Animal animal) {
        if (animal instanceof Carnivoro) {
            ((Carnivoro) animal).comerCarne();
        } else if (animal instanceof Herviboro) {
            ((Herviboro) animal).comerHierba();
        } else {
            System.out.println(animal.getNombre() + " tiene hábitos alimenticios desconocidos.");
        }
    }
}