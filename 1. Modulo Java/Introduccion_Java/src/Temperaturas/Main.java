package Temperaturas;

public class Main {
    public static void main(String[] args) {
        String[] cities ={"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo"
                ,"Lima", "Santiago de Chile", "Lisboa", "Tokio"};
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

        int lowest_index = 0;
        int lowest_temp = 0;
        int higher_index = 0;
        int higher_temp = 0;

        for (int i = 0; i < cities.length; i++) {
            if (higher_temp < temperatures[i][1]) {
                higher_index = i;
                higher_temp = temperatures[i][1];
            }
            if (lowest_temp > temperatures[i][0]) {
                lowest_index = i;
                lowest_temp = temperatures[i][0];
            }
        }

        System.out.println("Temperatura más baja: " + cities[lowest_index] + ": " + temperatures[lowest_index][0]);
        System.out.println("Temperatura más alta: " + cities[higher_index] + ": " + temperatures[higher_index][1]);
    }
}
