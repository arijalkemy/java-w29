package com.tempglobales.temperaturas;

public final class TemperaturasApplication {
    private TemperaturasApplication() {
    }

    private static int findLowestTemp(int[][] temperatures) {
        int lower = Integer.MAX_VALUE;
        int indexFinded = -1;

        for (int index = 0; index < temperatures.length; index++) {
            if (temperatures[index][0] < lower) {
                lower = temperatures[index][0];
                indexFinded = index;
            }
        }
        ;
        return indexFinded;
    }

    private static int findHighestTemp(int[][] temperatures) {

        int higher = Integer.MIN_VALUE;
        int indexFinded = -1;

        for (int index = 0; index < temperatures.length; index++) {
            if (temperatures[index][1] > higher) {
                higher = temperatures[index][1];
                indexFinded = index;
            }
        }
        ;
        return indexFinded;
    }

    private static void generalWeatherReport() {
        String[] cities = { "Londres",
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

        int[][] temperatures = { { -2, 33 },
                { -3, 32 },
                { -8, 27 },
                { 4, 37 },
                { 6, 42 },
                { 5, 43 },
                { 0, 39 },
                { -7, 26 },
                { -1, 31 },
                { -10, 35 },
        };

        int lowestIndex = findLowestTemp(temperatures);
        int highestIndex = findHighestTemp(temperatures);

        if (lowestIndex > 0) {
            System.out.println(String.format("The city with the lowest temperature was %s with %s °C.",
                    cities[lowestIndex], temperatures[lowestIndex][0]));
        } else {
            System.out.println("Error finding the lowest");
        }
        if (highestIndex > 0) {
            System.out.println(String.format("The city with the highest temperature was %s with %s °C.",
                    cities[highestIndex], temperatures[highestIndex][1]));

        } else {
            System.out.println("Error finding the highest");
        }
    }

    public static void main(String[] args) {

        generalWeatherReport();

    }
}


