package com.bootcamp;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción",
                "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        int[][] temperaturas = {
                {-2, 33}, // Londres
                {-3, 32}, // Madrid
                {-8, 27}, // Nueva York
                {4, 37}, // Buenos Aires
                {6, 42}, // Asunción
                {5, 43}, // São Paulo
                {0, 39}, // Lima
                {-7, 26}, // Santiago de Chile
                {-1, 31}, // Lisboa
                {-10, 35} // Tokio
        };

        int maxTemp = 0;
        int minTemp = 0;
        String paisMax = "";
        String paisMin = "";

        for (int i = 0; i < temperaturas.length; i++) {
            if (maxTemp < temperaturas[i][1]) {
                maxTemp = temperaturas[i][1];
                paisMax = ciudades[i];
            }
            if (minTemp > temperaturas[i][0]) {
                minTemp = temperaturas[i][0];
                paisMin = ciudades[i];
            }
        }

        System.out.println("La temperatura mayor la tuvo " + paisMax + " y fu\u00e9 de " + maxTemp + "\u00ba C.");
        System.out.println("La temperatura menor la tuvo " + paisMin + " y fu\u00e9 de " + minTemp + "\u00ba C.");
        System.out.println("");
        System.out.println(otraSolucion());;


    }

    private static String otraSolucion() {
        String msj = "";
        Map<String, int[][]> temperaturas = new HashMap<>();
        temperaturas.put("Londres", new int[][]{{-2, 33}});
        temperaturas.put("Madrid", new int[][]{{-3, 32}});
        temperaturas.put("Nueva York", new int[][]{{-8, 27}});
        temperaturas.put("Buenos Aires", new int[][]{{4, 37}});
        temperaturas.put("Asunción", new int[][]{{6, 42}});
        temperaturas.put("São Paulo", new int[][]{{5, 43}});
        temperaturas.put("Lima", new int[][]{{0, 39}});
        temperaturas.put("Santiago de Chile", new int[][]{{-7, 26}});
        temperaturas.put("Lisboa", new int[][]{{-1, 31}});
        temperaturas.put("Tokio", new int[][]{{-10, 35}});

        int maxTemp = 0;
        int minTemp = 0;
        String paisMax = "";
        String paisMin = "";

        for (Map.Entry<String, int[][]> entry : temperaturas.entrySet()) {
            String k = entry.getKey();
            int[][] v = entry.getValue();
            if (maxTemp < v[0][1]) {
                maxTemp = v[0][1];
                paisMax = k;
            }
            if (minTemp > v[0][0]) {
                minTemp = v[0][0];
                paisMin = k;
            }
        }

        return msj = "La temperatura mayor la tuvo " + paisMax + " y fu\u00e9 de " + maxTemp + "\u00ba C." + "\n" +
                "La temperatura menor la tuvo " + paisMin + " y fu\u00e9 de " + minTemp + "\u00ba C.";
    }


}