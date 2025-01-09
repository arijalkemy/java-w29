package com.thiagoschreck.local;

public class App {
    public static void main(String[] args) {
        TemperaturasGlobales.printDatosDeTemperaturas();
    }
}

class TemperaturasGlobales {
    static String[] ciudades = {
            "Londres",
            "Madrid",
            "Nueva York",
            "Buenos Aires",
            "Asunción",
            "Sao Paulo",
            "Lima",
            "Santiago de Chile",
            "Lisboa",
            "Tokio",
    };
    static int[][] temperaturas = {
            {-2, 33},
            {-3, 32},
            {-8, 27},
            {4, 37},
            {6, 42},
            {5, 43},
            {0, 39},
            {-7, 26},
            {-1, 31},
            {-10, 35},
    };

    public static void printDatosDeTemperaturas() {
        int menorTemperatura = temperaturas[0][0];
        int mayorTemperatura = temperaturas[0][1];
        int idxMenorTemperatura = 0;
        int idxMayorTemperatura = 0;

        for (int i = 1; i < temperaturas.length; i++) {
            if (temperaturas[i][0] < menorTemperatura) {
                menorTemperatura = temperaturas[i][0];
                idxMenorTemperatura = i;
            }
            if (temperaturas[i][1] > mayorTemperatura) {
                mayorTemperatura = temperaturas[i][1];
                idxMayorTemperatura = i;
            }
        }

        System.out.printf("La menor temperatura es de %s, en la ciudad de %s%n", menorTemperatura, ciudades[idxMenorTemperatura]);
        System.out.printf("La mayor temperatura es de %s, en la ciudad de %s%n", mayorTemperatura, ciudades[idxMayorTemperatura]);
    }
}