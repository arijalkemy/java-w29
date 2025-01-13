package org.example;

public class Main {
    public static void main(String[] args) {
        String[] cities = new String[10];

        cities[1] = "Madrid";
        cities[2] = "Nueva York";
        cities[3] = "Buenos Aires";
        cities[4] = "Asuncion";
        cities[5] = "São Paulo";
        cities[6] = "Lima";
        cities[7] ="Santiago de chile";
        cities[8] = "Lisboa";
        cities[9] = "Tokio";

        Integer[][] temperatures = {
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

        Integer minTemp = temperatures[0][0];
        Integer maxTemp = temperatures[0][0];
        String cityMinTemp = cities[0];
        String cityMaxTemp = cities[0];

        for(int f = 0; f < temperatures.length; f++) {
            for(int c = 0; c < temperatures[f].length; c++) {
                if(temperatures[f][c] < minTemp) {
                    minTemp = temperatures[f][c];
                    cityMinTemp = cities[f];
                }
                if(temperatures[f][c] > maxTemp) {
                    maxTemp = temperatures[f][c];
                    cityMaxTemp = cities[f];
                }
            }
        }


        System.out.println("La ciudad con menor temperatura es: " + cityMinTemp + " con una temperatura de " + minTemp);
        System.out.println("La ciudad con mayor temperatura es: " + cityMaxTemp + " con una temperatura de " + maxTemp);
    }
}