package org.example.fauna;

public class Vaca extends Animal implements ComerHierva{
    @Override
    public String emitirSonido() {
        return "Muuu";
    }

    @Override
    public String comer() {
        return "Comiendo hierva...";
    }
}
