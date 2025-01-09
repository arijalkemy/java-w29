public class TemperaturaCiudades {
    public static void main(String[] args) {

        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires",
                "Asunción", "São Paulo", "Lima", "Santiago de Chile",
                "Lisboa", "Tokio"};

        int[][] temperaturas = {
                {-2, 33}, {-3, 32}, {-8, 27}, {4, 37},
                {6, 42}, {5, 43}, {0, 39}, {-7, 26},
                {-1, 31}, {-10, 35}
        };

        // Imprimir la ciudad con la temperatura más baja y la más alta
        int tempMin = temperaturas[0][0];
        int tempMax = temperaturas[0][1];

        String ciudadTempMin = ciudades[0];
        String ciudadTempMax = ciudades[0];

        for (int i = 1; i < ciudades.length; i++) {
            if (temperaturas[i][0] < tempMin) {
                tempMin = temperaturas[i][0];
                ciudadTempMin = ciudades[i];
            }
            if (temperaturas[i][1] > tempMax) {
                tempMax = temperaturas[i][1];
                ciudadTempMax = ciudades[i];
            }
        }

        System.out.println("Ciudad con la temperatura más baja: " + ciudadTempMin + " (" + tempMin + "°C)");
        System.out.println("Ciudad con la temperatura más alta: " + ciudadTempMax + " (" + tempMax + "°C)");




    }
}