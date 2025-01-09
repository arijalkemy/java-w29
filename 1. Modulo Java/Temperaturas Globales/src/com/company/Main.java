package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] nombreCiudades = {"Londres", "Madrid","Nueva York","Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        List<String> nombresOrdenados = Arrays.asList(nombreCiudades);
        String[] listaFinal = (String[]) nombresOrdenados.stream()
                .sorted((x, y) -> x.compareTo(y))
                .toArray();
        nombresOrdenados.stream().toArray();

        int[][] temperaturasCiudades = {
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
        int temperaturaMenor = 0;
        String ciudadTemperaturaMenor = "";
        int temperaturaMayor = 0;
        String ciudadTemperaturaMayor = "";
        for (int f = 0; f < 10; f++) {
            if (temperaturasCiudades[f][0] < temperaturaMenor){
                temperaturaMenor = temperaturasCiudades[f][0];
                ciudadTemperaturaMenor = nombreCiudades[f];
            }
            if (temperaturasCiudades[f][1] > temperaturaMayor){
                temperaturaMayor = temperaturasCiudades[f][1];
                ciudadTemperaturaMayor = nombreCiudades[f];
            }
        }

        System.out.println("Ciudad con mayor temperatura: " + ciudadTemperaturaMayor + ". Temperatura: " +temperaturaMayor + "°C");
        System.out.println("Ciudad con menor temperatura: " + ciudadTemperaturaMenor + ". Temperatura: " + temperaturaMenor + "°C");

    }
}
