package org.example;

public class Main {
    public static void main(String[] args) {
        String[] ciudades = {
                "Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción",
                "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"
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

        int tempMin = Integer.MAX_VALUE;
        int tempMax = Integer.MIN_VALUE;
        String ciudadMin = "";
        String ciudadMax = "";

        for (int i = 0; i < ciudades.length; i++) {
            int tempMinCiudad = temperaturas[i][0];
            int tempMaxCiudad = temperaturas[i][1];

            if (tempMinCiudad < tempMin) {
                tempMin = tempMinCiudad;
                ciudadMin = ciudades[i];
            }

            if (tempMaxCiudad > tempMax) {
                tempMax = tempMaxCiudad;
                ciudadMax = ciudades[i];
            }


        }

        System.out.println("La ciudad con la temperatura mínima fue " + ciudadMin + ", con " + tempMin + "°C.");
        System.out.println("La ciudad con la temperatura máxima fue " + ciudadMax + ", con " + tempMax + "°C.");
    }
}