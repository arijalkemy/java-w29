public class Main {
    public static void main(String[] args) {

        String[] ciudades = {"Londres", "Madrid", "Nueva York",
                "Buenos Aires", "Asunción", "Sao Paulo", "Lima",
                "Santiago de Chile", "Lisboa", "Tokio"};

        int[][] temperaturas = {{-2, 33}, {-3, 32}, {-8, 27},
                {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}
                , {-1, 31}, {-10, 35}};

        int min = temperaturas[0][0];
        int max = temperaturas[0][0];
        int minCiudad = 0;
        int maxCiudad = 0;

        for (int i = 0; i < temperaturas.length; i++) {
            for (int j = 0; j < temperaturas[i].length; j++) {

                if (temperaturas[i][j] < min) {
                    min = temperaturas[i][j];
                    minCiudad = i;
                }

                if (temperaturas[i][j] > max) {
                    max = temperaturas[i][j];
                    maxCiudad = i;
                }
            }
        }

        System.out.println("La menor temperatura la tuvo " +
                ciudades[minCiudad] + ", con " + min + " °C");
        System.out.println("La mayor temperatura la tuvo " +
                ciudades[maxCiudad] + ", con " + max + " °C");


    }

}
