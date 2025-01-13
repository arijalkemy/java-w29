package com.exercise3;

public interface Herbivoro {
    static void comer() {
        System.out.println("Comiendo hierba");
    }

    default void comiendo() {
        System.out.println("Comiendo hierba");
    }
}
