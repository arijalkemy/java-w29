public class Main {
    public static void main(String[] args) {
        String[] ciudades = {
                "Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción",
                "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"
        };


        int[][] temperaturas = {
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


        int temperaturaMinima = 9999;
        int temperaturaMaxima = -9999;
        String ciudadMinima = "";
        String ciudadMaxima = "";


        for (int i = 0; i < ciudades.length; i++) {
            int minima = temperaturas[i][0];
            int maxima = temperaturas[i][1];


            if (minima < temperaturaMinima) {
                temperaturaMinima = minima;
                ciudadMinima = ciudades[i];
            }


            if (maxima > temperaturaMaxima) {
                temperaturaMaxima = maxima;
                ciudadMaxima = ciudades[i];
            }
        }


        System.out.println("La menor temperatura fue en " + ciudadMinima + ": " + temperaturaMinima + "C");
        System.out.println("La mayor temperatura fue en " + ciudadMaxima + ": " + temperaturaMaxima + "C");
    }
}
