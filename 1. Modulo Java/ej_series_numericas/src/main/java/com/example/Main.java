package com.example;

public class Main {
    public static void main(String[] args) {
        Prototipo<Integer> serieDe5 = new SerieInteger(1, 5);

        for (int i = 0; i < 10; i++) {
            System.out.println(serieDe5.obtenerSiguiente());
        }

    }
}
