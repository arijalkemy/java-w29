package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        // Temperatura
        String vectorCiudades[] = new String[4];
        double matrizTemperaturas[][] = new double[10][2];
        double tempMin, tempMax;
        String ciudadMin, ciudadMax;
        Scanner teclado = new Scanner(System.in);

        System.out.println("------------------------------");
        System.out.println("Bienvenido al programa de temperturas");
        System.out.println("------------------------------");
        System.out.println("Ingrese la informacion de las ciudades");


        for (int f = 0; f <= 10; f++) {
            System.out.println("Ingrese el nombre de la ciudad numero " + (f +1) + ":");
            vectorCiudades[f] = teclado.nextLine();



            for (int c = 0; c <= 1; c++) {

                if (c == 0){
                    System.out.println("Ingrese la temperatura minima de la ciudad " + vectorCiudades[f] + ":");
                    matrizTemperaturas[f][c] = teclado.nextInt();
                    teclado.nextLine();


                }else{
                    System.out.println("Ingrese la temperatura Maxima de la ciudad " + vectorCiudades[f] + ":");
                    matrizTemperaturas[f][c] = teclado.nextInt();
                    teclado.nextLine();

                }
            }
        }
        tempMin = matrizTemperaturas[0][0];
        tempMax = matrizTemperaturas[0][0];
        ciudadMin = vectorCiudades[0];
        ciudadMax = vectorCiudades[0];

        for (int f = 0; f <= 3; f++) {
            for (int c = 0; c <= 1; c++) {
                if (matrizTemperaturas[f][c] > tempMax) {
                    tempMax = matrizTemperaturas[f][c];
                    ciudadMax = vectorCiudades[f];
                }

                if (matrizTemperaturas[f][c] < tempMin) {
                    tempMin = matrizTemperaturas[f][c];
                    ciudadMin = vectorCiudades[f];

                }
            }
        }
        System.out.println("------------------------------");
        System.out.println("Resultados del programa de temperaturas");
        System.out.println("la ciudad de: " + ciudadMin + " con la temperatura minima de: " + tempMin);
        System.out.println("la ciudad de: " + ciudadMax + " con la temperatura maxima de: " + tempMax);

    }
}