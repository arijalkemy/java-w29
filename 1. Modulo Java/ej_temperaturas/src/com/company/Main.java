package com.company;

public class Main {

    public static void main(String[] args) {
        String ciudades[] = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Paulo",
                "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int temperaturas[][] = {{-2, -3, -8, 4, 6, 5, 0, -7, -1, -10}, {33, 32, 27, 37, 42, 43, 39, 26, 31, 35}};

        String ciudadTemperaturaMax = ciudades[0];
        String ciudadTemperaturaMin = ciudades[0];
        int temperaturaMax = temperaturas[0][1];
        int temperaturaMin = temperaturas[0][0];

        for (int i= 1; i<10; i++){
            if(temperaturas[1][i] > temperaturaMax){
                temperaturaMax = temperaturas[1][i];
                ciudadTemperaturaMax = ciudades[i];
            }

            if(temperaturas[0][i] < temperaturaMin){
                temperaturaMin = temperaturas[0][i];
                ciudadTemperaturaMin = ciudades[i];
            }
        }

        System.out.printf("La ciudad con máxima temperatura es: %s con %d grados\n", ciudadTemperaturaMax, temperaturaMax);
        System.out.printf("La ciudad con mínima temperatura es: %s con %d grados\n", ciudadTemperaturaMin, temperaturaMin);
    }
}
