package com.exercise3;

public interface Carnivoro {
    static void comer() {
        System.out.println("Comiendo Carne");
    }

    default void comiendo() {
        System.out.println("Comiendo Carne");
    }
}
