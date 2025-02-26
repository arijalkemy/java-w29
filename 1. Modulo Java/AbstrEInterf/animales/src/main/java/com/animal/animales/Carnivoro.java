package com.animal.animales;

public interface Carnivoro {
    static void comer() {
        System.out.println("Comiendo Carne");
    }

    default void comiendo() {
        System.out.println("Comiendo Carne");
    }
}
