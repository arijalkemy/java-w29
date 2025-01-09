package org.meli;

import org.meli.interfaces.Carnivoro;
import org.meli.interfaces.Herbivoro;
import org.meli.models.Animal;
import org.meli.models.Gato;
import org.meli.models.Perro;
import org.meli.models.Vaca;

public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro("Firulais");
        Gato gato = new Gato("Michi");
        Vaca vaca = new Vaca("Lola");

        perro.emitirSonido();
        gato.emitirSonido();
        vaca.emitirSonido();

        comerAnimal(perro);
        comerAnimal(gato);
        comerAnimal(vaca);
    }

    public static void comerAnimal(Animal animal) {
        System.out.println("\nInvocando el método comer para " + animal.getNombre());
        if (animal instanceof Carnivoro) {
            ((Carnivoro) animal).comerCarne();
        } else if (animal instanceof Herbivoro) {
            ((Herbivoro) animal).comerHierba();
        }
    }
}