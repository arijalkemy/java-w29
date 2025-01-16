public class Main {

    public enum TemperatureType {
        MIN, MAX
    }

    public static int get_temperature(TemperatureType type, int[][] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            throw new IllegalArgumentException("Temperatures data cannot be null or empty.");
        }

        int best_idx = 0;
        int best_temperature = type == TemperatureType.MIN ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        int type_idx = type == TemperatureType.MIN ? 0 : 1;

        for (int i = 0; i < temperatures.length; i++) {
            int current_temperature = temperatures[i][type_idx];
            if ((type == TemperatureType.MIN && current_temperature < best_temperature) ||
                    (type == TemperatureType.MAX && current_temperature > best_temperature)) {
                best_temperature = current_temperature;
                best_idx = i;
            }
        }

        return best_idx;
    }

    public static void displayTemperatureInfo(String[] cities, int[][] temperatures, TemperatureType type) {
        int idx = get_temperature(type, temperatures);
        int temperature = temperatures[idx][type == TemperatureType.MIN ? 0 : 1];
        String city = cities[idx];
        String label = type == TemperatureType.MIN ? "Min" : "Max";

        System.out.println(label + " temperature is: " + city + " - " + temperature);
    }

    public static void main(String[] args) {
        String[] cities = {
                "London",
                "Madrid",
                "New York",
                "Buenos Aires",
                "Asuncion",
                "Sao Paulo",
                "Lima",
                "Santiago",
                "Lisbon",
                "Tokio"
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

        displayTemperatureInfo(cities, temperatures, TemperatureType.MIN);
        displayTemperatureInfo(cities, temperatures, TemperatureType.MAX);
    }
}
