public class Main {
    public static void main(String[] args) {

        String[] ciudades = new String[10];
        ciudades[0] = "Londres";
        ciudades[1] = "Madrid";
        ciudades[2] = "Nueva York";
        ciudades[3] = "Buenos Aires";
        ciudades[4] = "Asuncion";
        ciudades[5] = "Sao Paulo";
        ciudades[6] = "Lima";
        ciudades[7] = "Santiago de Chile";
        ciudades[8] = "Lisboa";
        ciudades[9] = "Tokio";

        int[][] temperaturasCiudades = {
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

        int min = temperaturasCiudades[0][0];
        int max = temperaturasCiudades[0][1];

        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 0; i < temperaturasCiudades.length; i++) {
            int prevMin = min;
            int prevMax = max;
            min = Math.min(min, temperaturasCiudades[i][0]);
            max = Math.max(max, temperaturasCiudades[i][1]);

            if (prevMin != min) minIndex = i;
            if (prevMax != max) maxIndex = i;

        }

        System.out.println(ciudades[minIndex]);
        System.out.println(ciudades[maxIndex]);

    }
}
