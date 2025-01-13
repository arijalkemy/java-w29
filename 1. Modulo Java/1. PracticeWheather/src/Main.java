import java.util.function.BiPredicate;

public class Main {
    public static void main(String[] args) {

        String[] cities = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
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

        int indexMax = 0;
        int indexMax2 = 0;
        int indexMin = 0;
        int indexMin2 = 0;

        for (int i = 1; i < temperatures.length; i++)
        {
            if(temperatures[i][1] > temperatures[indexMax][1]) {
                indexMax = i;
            }

            if(temperatures[i][0] < temperatures[indexMin][0]) {
                indexMin = i;
            }
        }

        System.out.println("La ciudad con mayor temperatura es " +  cities[indexMax] + " con " + temperatures[indexMax][1] + " °C");
        System.out.println("La ciudad con menor temperatura es " +  cities[indexMin] + " con " + temperatures[indexMin][0] + " °C");

        //Another solution
        indexMax2 = searchTemperature(temperatures, 1, (a, b) -> a > b);
        indexMin2 = searchTemperature(temperatures, 0, (a, b) -> a < b);

        System.out.println("La ciudad con mayor temperatura es " +  cities[indexMax2] + " con " + temperatures[indexMax2][1] + " °C");
        System.out.println("La ciudad con menor temperatura es " +  cities[indexMin2] + " con " + temperatures[indexMin2][0] + " °C");

    }

    /**
     * Function than depends of validation return an index
     * @param temperatures matrix whith temperatures
     * @param column min 0 or max 1 column
     * @param validation validation
     * @return index solution
     */
    public static int searchTemperature(int[][] temperatures, int column, BiPredicate<Integer, Integer> validation) {
        int index = 0;
        for(int i = 0; i < temperatures.length; i++) {
            if(validation.test(temperatures[i][column], temperatures[index][column])) {
                index = i;
            }
        }

        return index;
    }
}