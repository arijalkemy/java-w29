//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] ciudades = new String[]{
                "Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asuncion",
                "Sao Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokio"};

        int[][] temperaturas = new int[][]{
                {-2,33},
                {-3,32},
                {-8,27},
                {4,37},
                {6,42},
                {5,43},
                {0,39},
                {-7,26},
                {-1,31},
                {-10,35}

        };

        int ind_min_temperatura = 0;
        int ind_max_temperatura = 0;


        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i][0] < temperaturas[ind_min_temperatura][0]) {
               ind_min_temperatura = i;

            }
            if (temperaturas[i][1] > temperaturas[ind_max_temperatura][1]) {
                ind_max_temperatura = i;
            }
        }

        System.out.println("La temperatura Minima fue de: " + temperaturas[ind_min_temperatura][0] + ", Ciudad: " + ciudades[ind_min_temperatura]);
        System.out.println("La temperatura Maxima fue de: " + temperaturas[ind_max_temperatura][1] + ", Ciudad: " + ciudades[ind_max_temperatura]);


    }
}