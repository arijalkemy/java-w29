package org.example.poo.part2;

public abstract class Animal {
    abstract void emitirSonido();

    static void comerAnimal(Animal animal){
        if (animal instanceof Carnivoro){
            ((Carnivoro) animal).comerCarne();
        } else if (animal instanceof Herbivoro){
            ((Herbivoro) animal).comerHierba();
        }
    }
}
