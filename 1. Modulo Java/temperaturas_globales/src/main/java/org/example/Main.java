package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
            String vectorCiudades [] = new String[10];
            vectorCiudades [0] = "Londres";
            vectorCiudades [1] = "Madrid";
            vectorCiudades [2] = "Nueva York";
            vectorCiudades [3] = "Buenos Aires";
            vectorCiudades [4] = "Asuncion";
            vectorCiudades [5] = "Sao Paulo";
            vectorCiudades [6] = "Lima";
            vectorCiudades [7] = "Santiago de Chile";
            vectorCiudades [8] = "Lisboa";
            vectorCiudades [9] = "Tokio";

            Double matrizTemperaturas [][] = new Double[10][2];
            matrizTemperaturas [0][0] = -2.0;
            matrizTemperaturas [0][1] = 33.0;
            matrizTemperaturas [1][0] = -3.0;
            matrizTemperaturas [1][1] = 32.0;
            matrizTemperaturas [2][0] = -8.0;
            matrizTemperaturas [2][1] = 27.0;
            matrizTemperaturas [3][0] = 4.0;
            matrizTemperaturas [3][1] = 37.0;
            matrizTemperaturas [4][0] = 6.0;
            matrizTemperaturas [4][1] = 42.0;
            matrizTemperaturas [5][0] = 5.0;
            matrizTemperaturas [5][1] = 43.0;
            matrizTemperaturas [6][0] = 0.0;
            matrizTemperaturas [6][1] = 39.0;
            matrizTemperaturas [7][0] = -7.0;
            matrizTemperaturas [7][1] = 26.0;
            matrizTemperaturas [8][0] = -1.0;
            matrizTemperaturas [8][1] = 31.0;
            matrizTemperaturas [9][0] = -10.0;
            matrizTemperaturas [9][1] = 35.0;


            // Imprimir encabezados
            System.out.printf("%-20s %-15s %-10s%n", "Ciudad", "Temp Mínima", "Temp Máxima");

            // Imprimir los datos
            for (int i = 0; i < vectorCiudades.length; i++) {
                    System.out.printf("%-23s %-15s %-10s%n", vectorCiudades[i], matrizTemperaturas[i][0], matrizTemperaturas[i][1]);
            }

            double tempMinima = Double.MAX_VALUE;
            String ciudadMinima = "";

            double tempMaxima = Double.MIN_VALUE;
            String ciudadMaxima = "";


            for (int i = 0; i < matrizTemperaturas.length; i++) {

                    if (matrizTemperaturas[i][0] < tempMinima) {
                            tempMinima = matrizTemperaturas[i][0];
                            ciudadMinima = vectorCiudades[i];
                    }

                    if (matrizTemperaturas[i][1] > tempMaxima) {
                            tempMaxima = matrizTemperaturas[i][1];
                            ciudadMaxima = vectorCiudades[i];
                    }
            }

            System.out.println("La temperatura mínima registrada es " + tempMinima + "°C en " + ciudadMinima);
            System.out.println("La temperatura máxima registrada es " + tempMaxima + "°C en " + ciudadMaxima);
    }
}
