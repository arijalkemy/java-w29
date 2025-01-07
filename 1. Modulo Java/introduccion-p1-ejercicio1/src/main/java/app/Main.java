package app;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String[] cities = {
                "Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asuncion",
                "Sao Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
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
                {-10, 35},
        };

        int minTemperature = temperatures[0][0];
        int maxTemperature = temperatures[0][1];

        String minCity = cities[0];
        String maxCity = cities[0];

        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i][0] < minTemperature) {
                minTemperature = temperatures[i][0];
                minCity = cities[i];
            }
            if (temperatures[i][1] > maxTemperature) {
                maxTemperature = temperatures[i][1];
                maxCity = cities[i];
            }
        }

        System.out.printf("Ciudad con temperatura minima: %s%n", minCity);
        System.out.printf("Ciudad con temperatura maxima: %s%n", maxCity);
    }


}