package org.example;

import org.example.animales.Gato;
import org.example.animales.Perro;
import org.example.animales.Vaca;

public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();
        System.out.println("Demostración del perro: ");
        perro.emitirSonido();
        System.out.println(perro.comerCarne());
        System.out.println("Demostración del gato: ");
        gato.emitirSonido();
        System.out.println(gato.comerCarne());
        System.out.println("Demostración de la vaca: ");
        vaca.emitirSonido();
        System.out.println(vaca.comerHierba());
    }
}