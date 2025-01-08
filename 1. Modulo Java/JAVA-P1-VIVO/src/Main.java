public class Main {
    public static void main(String[] args) {

        String[] cities = {
                "Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción",
                "San Pablo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"
        };

        int[][] temps = {
                {-2, 33}, {-3, 32},
                {-8, 27}, {4, 37},
                {6, 42}, {5, 43},
                {0, 39}, {-7, 26},
                {-1, 31}, {-10, 35}
        };

        int minTempIdx = 0;
        int maxTempIdx = 0;

        for (int i = 0; i < cities.length; i++) {
            if (temps[i][0] < temps[minTempIdx][0]) {
                minTempIdx = i;
            }
            if (temps[i][1] > temps[maxTempIdx][1]) {
                maxTempIdx = i;
            }
        }

        System.out.printf("La ciudad con menor temperatura es %s con %d%n", cities[minTempIdx], temps[minTempIdx][0]);
        System.out.printf("La ciudad con mayor temperatura es %s con %d%n", cities[maxTempIdx], temps[maxTempIdx][1]);



    }
}