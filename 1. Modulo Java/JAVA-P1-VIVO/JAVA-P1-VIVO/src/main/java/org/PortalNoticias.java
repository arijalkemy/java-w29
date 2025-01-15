package org;

public class PortalNoticias {
    public static void main(String[] args) {
        // Vector de ciudades
        String[] ciudades = {
                "Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción",
                "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"
        };

        // Matriz de temperaturas: [minima, maxima]
        int[][] temperaturas = {
                {-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42},
                {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}
        };

        // Variables para encontrar las temperaturas extremas
        int menorTemperatura = Integer.MAX_VALUE;
        int mayorTemperatura = Integer.MIN_VALUE;

        String ciudadMenorTemperatura = "";
        String ciudadMayorTemperatura = "";

        // Recorrer las ciudades y las temperaturas
        for (int i = 0; i < ciudades.length; i++) {
            // Verificar la menor temperatura
            if (temperaturas[i][0] < menorTemperatura) {
                menorTemperatura = temperaturas[i][0];
                ciudadMenorTemperatura = ciudades[i];
            }

            // Verificar la mayor temperatura
            if (temperaturas[i][1] > mayorTemperatura) {
                mayorTemperatura = temperaturas[i][1];
                ciudadMayorTemperatura = ciudades[i];
            }
        }

        // Imprimir resultados
        System.out.println("La menor temperatura la tuvo " + ciudadMenorTemperatura + ", con " + menorTemperatura + " ºC.");
        System.out.println("La mayor temperatura la tuvo " + ciudadMayorTemperatura + ", con " + mayorTemperatura + " ºC.");
    }
}

