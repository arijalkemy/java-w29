import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] citys = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "Sao Paulo", "Lima", "Santiago de chile", "Lisboa", "Tokio"};
        int[][] temperatures = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};
        int cityMinTemperature = 0;
        int cityMaxTemperature = 0;
        int positionMin = 0;
        int positionMax = 0;

        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 1; j++) {
                if (temperatures[i][j] < cityMinTemperature) {
                    cityMinTemperature = temperatures[i][j];
                    positionMin = i;
                }
                if (temperatures[i][j] > cityMaxTemperature) {
                    cityMaxTemperature = temperatures[i][j];
                    positionMax = i;
                }
            }
        }
        System.out.println("------------------------------------------------------");
        System.out.println("la ciudad mas fría fue: " + citys[positionMin] + " con una temperatura fue de: " + cityMinTemperature);
        System.out.println("------------------------------------------------------");
        System.out.println("la ciudad mas calurosa fue: " + citys[positionMax] + " con una temperatura fue de: " + cityMaxTemperature);
        System.out.println("------------------------------------------------------");

    }
}