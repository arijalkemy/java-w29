package com.example;

public class Main {
    public static void main(String[] args) {

        String[] ciudades = {
                "Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "Sao Paulo", "Lima",
                "Santiago de Chile", "Lisboa", "Tokio"
        };

        int[][] temperaturas = {
                {-2, 33},
                {-3, 32},
                {-8, 27},
                {4, 37},
                {6, 42},
                {5, 43},
                {0, 39},
                {-7, 26},
                {-1, 31},
                {-10, 35}
        };

        int menor = 0;
        int mayor = 0;

        for (int i = 0; i < ciudades.length; i++) {
            if (temperaturas[i][0] < temperaturas[menor][0]) menor = i;
            if (temperaturas[i][1] > temperaturas[mayor][1]) mayor = i;
        }

        System.out.printf("Temperatura mínima: %s | %d°%n", ciudades[menor], temperaturas[menor][0]);
        System.out.printf("Temperatura máxima: %s | %d°%n", ciudades[mayor], temperaturas[mayor][0]);
    }
}
