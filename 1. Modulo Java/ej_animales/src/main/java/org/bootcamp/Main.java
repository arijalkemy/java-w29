package org.bootcamp;

public class Main {
    public static void main(String[] args) {

        Perro ringo = new Perro();
        Gato garfield = new Gato();
        Vaca lola = new Vaca();

        ringo.emitirSonido();
        ringo.comerCarne();
        garfield.emitirSonido();
        garfield.comerCarne();
        lola.emitirSonido();
        lola.comerHierba();
    }
}