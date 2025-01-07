package org.example;

public class Main {
    public static void main(String[] args) {
        String[] ciudades = {
                "Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asunción",
                "São Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokio"
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

        double tempMinima = Double.MAX_VALUE;
        double tempMaxima = Double.MIN_VALUE;
        String ciudadTempMinima = "";
        String ciudadTempMaxima = "";


        for (int i = 0; i < ciudades.length; i++) {
            for (int j = 0; j < 1; j++) {

                if (temperaturas[i][j] < tempMinima) {
                    tempMinima = temperaturas[i][j];
                    ciudadTempMinima = ciudades[i];
                }

                if (temperaturas[i][j] > tempMaxima) {
                    tempMaxima = temperaturas[i][j];
                    ciudadTempMaxima = ciudades[i];
                }

            }

        }
        System.out.println("La ciudad " + ciudadTempMinima + " es la ciudad con la mínima temperatura de: " + tempMinima);
        System.out.println("La ciudad " + ciudadTempMaxima + " es la ciudad con la máxima temperatura de: " + tempMaxima);
    }
}
