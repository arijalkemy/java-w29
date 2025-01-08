package org.example;

import java.util.function.BiPredicate;

public class Main {
    public static void main(String[] args) {
        String[] ciudades = {
                "Londres", "Madrid", "Nueva York", "Buenos Aires",
                "Asunción", "San Pablo", "Lima", "Santiago de Chile",
                "Lisboa", "Tokio"
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
        String ciudadMasAlta = encontrarTemperaturaMasAlta(temperaturas, ciudades, (a,b) -> a > b);
        System.out.println(ciudadMasAlta);
        String ciudadMasBaja = encontrarTemperaturaMasBaja(temperaturas, ciudades, (a,b) -> a < b);
        System.out.println(ciudadMasBaja);
        /*for (int i = 0; i < ciudades.length; i++) {
            System.out.println(ciudades[i] + ": Min " + temperaturas[i][0] + "°C, Max " + temperaturas[i][1] + "°C");
        }*/
    }

    public static String encontrarTemperaturaMasAlta(int[][] temperaturas, String[] ciudades, BiPredicate<Integer, Integer> condicion){
        int temperaturaMasAlta = Integer.MIN_VALUE;
        int ciudad = 0;
        for(int i = 0; i <= temperaturas.length-1; i++){
            if(condicion.test(temperaturas[i][1], temperaturaMasAlta)){
                temperaturaMasAlta = temperaturas[i][1];
                ciudad = i;
            }
        }
        return "La temperatura más alta se registró en la ciudad de " + ciudades[ciudad] + ": " + temperaturaMasAlta + "°C";
    }

    public static String encontrarTemperaturaMasBaja(int[][] temperaturas, String[] ciudades, BiPredicate<Integer, Integer> condicion){
        int temperaturaMasBaja = Integer.MAX_VALUE;
        int ciudad = 0;
        for(int i = 0; i <= temperaturas.length-1; i++){
            if(condicion.test(temperaturas[i][0], temperaturaMasBaja)){
                temperaturaMasBaja = temperaturas[i][0];
                ciudad = i;
            }
        }
        return "La temperatura más baja se registró en la ciudad de " + ciudades[ciudad] + ": " + temperaturaMasBaja + "°C";
    }

    /*public static void main(String[] args) {
        String ciudades[] = new String[10];
        ciudades[0] = "Londres";
        ciudades[1] = "Madrid";
        ciudades[2] = "Nueva York";
        ciudades[3] = "Buenos Aires";
        ciudades[4] = "Asunción";
        ciudades[5] = "San Pablo";
        ciudades[6] = "Lima";
        ciudades[7] = "Santiago de Chile";
        ciudades[8] = "Lisboa";
        ciudades[9] = "Tokio";

        int temperaturas[][] = new int[10][2];
        temperaturas[0][0] = -2;
        temperaturas[0][1] = 33;
        temperaturas[1][0] = -3;
        temperaturas[1][1] = 32;
        temperaturas[2][0] = -8;
        temperaturas[2][1] = 27;
        temperaturas[3][0] = 4;
        temperaturas[3][1] = 37;
        temperaturas[4][0] = 6;
        temperaturas[4][1] = 42;
        temperaturas[5][0] = 5;
        temperaturas[5][1] = 43;
        temperaturas[6][0] = 0;
        temperaturas[6][1] = 39;
        temperaturas[7][0] = -7;
        temperaturas[7][1] = 26;
        temperaturas[8][0] = -1;
        temperaturas[8][1] = 31;
        temperaturas[9][0] = -10;
        temperaturas[9][1] = 35;

        for(int f = 0; f <= 9; f++){
            int tempMin = 0;
            int tempMax = 0;
            for(int c = 0; c <= 1; c++){
                if(c == 0){
                    tempMin = temperaturas[f][c];
                } else if (c == 1) {
                    tempMax = temperaturas[f][c];
                }
            }
            System.out.println("Ciudad " + ciudades[f] + "; Temp min: " + tempMin + "; Temp max: " + tempMax);
        }

    }*/
}