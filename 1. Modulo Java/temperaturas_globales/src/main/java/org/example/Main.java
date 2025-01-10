package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String[] cities = {
                "London",
                "Madrid",
                "New York",
                "Buenos Aires",
                "Asuncion",
                "Sao Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisbon",
                "Tokyo"
        };

        int[][] temperatures = {
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

        String minCityName = cities[0];
        double minTemperature = temperatures[0][0];
        String maxCityName = cities[0];
        double maxTemperature = temperatures[0][1];


        for(int row = 1; row < cities.length; row++) {

            if(temperatures[row][0] < minTemperature) {
                minTemperature = temperatures[row][0];
                minCityName = cities[row];
            }

            if(temperatures[row][1] > maxTemperature) {
                maxTemperature = temperatures[row][1];
                maxCityName = cities[row];
            }
        }

        System.out.println("La ciudad con menor temperatura es " + minCityName + " con " + minTemperature + "º C.");
        System.out.println("La ciudad con mayor temperatura es " + maxCityName + " con " + maxTemperature + "º C.");
    }
}