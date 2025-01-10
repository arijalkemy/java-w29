package org.example.fauna;

public class Perro extends Animal implements ComerCarne{
    @Override
    public String emitirSonido() {
        return "Guau";
    }
    @Override
    public String comer() {
        return "Comiendo carne...";
    }

    @Override
    public String comerAnimal(Animal animal) {
        return this.comer();
    }

}
