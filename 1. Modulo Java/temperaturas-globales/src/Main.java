public class Main {
    public static void main(String[] args) {

        String[] ciudades = {
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

        int[][] temperaturas = {
                {-1, 33},
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
        int idxCiudadMenorTemp = 0, idxCiudadMayorTemp = 0;
        int menorTemp = temperaturas[0][0], mayorTemp = temperaturas[0][0];

        for (int i = 0; i < ciudades.length; i++) {
            for (int j = 0; j < 2; j++) {
                if (temperaturas[i][j] < menorTemp) {
                    menorTemp = temperaturas[i][j];
                    idxCiudadMenorTemp = i;
                }
                if (temperaturas[i][j] > mayorTemp) {
                    mayorTemp = temperaturas[i][j];
                    idxCiudadMayorTemp = i;
                }
            }
        }

        System.out.println("La ciudad con menor temperatura es: " + ciudades[idxCiudadMenorTemp] + ", temp: " + menorTemp);
        System.out.println("La ciudad con mayor temperatura es: " + ciudades[idxCiudadMayorTemp] + ", temp: " + mayorTemp);
    }
}

