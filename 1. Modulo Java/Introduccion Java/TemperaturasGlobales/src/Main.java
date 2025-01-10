public class Main {
    public static void main(String[] args) {

        //add cities
        String[] cities = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción",
                "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        //add temperatures
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

        //calculate minimum temperature
        int minimumTemperature = temperatures[0][0];
        String minimumCity = null;
        for (int f = 0; f < 10; f++) {
            for (int c = 0; c < 2; c++) {
                int temperature = temperatures[f][c];
                if (temperature < minimumTemperature) {
                    minimumTemperature = temperature;
                    minimumCity = cities[f];
                }
            }
        }
        System.out.println("Minimum temperature : the city is " + minimumCity + " and its temperature is " + minimumTemperature);

        //calculate maximum temperature
        int maximumTemperature = temperatures[0][0];
        String maximunCity = null;
        for (int f = 0; f < 10; f++) {
            for (int c = 0; c < 2; c++) {
                int temperature = temperatures[f][c];
                if (temperature > maximumTemperature) {
                    maximumTemperature = temperature;
                    maximunCity = cities[f];
                }
            }
        }
        System.out.println("Maximun temperature: the city is " + maximunCity + " and its temperature is " + maximumTemperature);
    }
}

