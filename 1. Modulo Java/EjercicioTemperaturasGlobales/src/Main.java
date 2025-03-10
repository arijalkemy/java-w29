public class Main {
    public static void main(String[] args) {
        String[] capitalCities = {
                "Londres",
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

        int[][] temperatures = {
                {-2, 33}, // Londres
                {-3, 32}, // Madrid
                {-8, 27}, // Nueva York
                {4, 37},  // Buenos Aires
                {6, 42},  // Asunción
                {5, 43},  // São Paulo
                {0, 39},  // Lima
                {-7, 26}, // Santiago de Chile
                {-1, 31}, // Lisboa
                {-10, 35} // Tokio
        };

        int minTemperature = 0;
        int maxTemperature = 0;
        String cityMinTemperature = "";
        String cityMaxTemperature = "";

        for (int i = 0; i < capitalCities.length; i++) {
            if (temperatures[i][0] < minTemperature) {
                minTemperature = temperatures[i][0];
                cityMinTemperature = capitalCities[i];
            }

            if (temperatures[i][1] > maxTemperature) {
                maxTemperature = temperatures[i][1];
                cityMaxTemperature = capitalCities[i];
            }
        }
        System.out.println("Ciudad con menor temperatura: " + cityMinTemperature + " con temperatura " + minTemperature);
        System.out.println("Ciudad con mayor temperatura: " + cityMaxTemperature + " con temperatura " + maxTemperature);
    }
}