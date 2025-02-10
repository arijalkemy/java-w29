import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String cities[] = new String[10];
        cities[0] = "Londres";
        cities[1] = "Madrid";
        cities[2] = "Nueva York";
        cities[3] = "Buenos Aires";
        cities[4] = "Asuncion";
        cities[5] = "São Paulo";
        cities[6] = "Lima";
        cities[7] ="Santiago de chile";
        cities[8] = "Lisboa";
        cities[9] = "Tokio";

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
        int minTempIndex = 0;
        int maxTempIndex = 0;
        for (int i = 0; i < temperatures.length; i++) {

            if (temperatures[i][0] < temperatures[i+1][0]) {
                minTempIndex = temperatures[i][0];
            }else {
                minTempIndex = temperatures[i+1][0];
            }
        }

        for (int i = 0; i < temperatures.length; i++) {

            if (temperatures[1][i] < temperatures[1][i+1]) {
                maxTempIndex = temperatures[1][i];
            }else {
                maxTempIndex = temperatures[1][i+1];
            }
        }

        System.out.println(cities[minTempIndex] + "tiene la temperatura minima de :" + Arrays.toString(temperatures[minTempIndex]));
        System.out.println(cities[maxTempIndex] + "tiene la temperatura minima de :" + Arrays.toString(temperatures[maxTempIndex]));
    }
}