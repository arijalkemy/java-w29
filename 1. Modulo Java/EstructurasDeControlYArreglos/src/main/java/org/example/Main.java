package org.example;

public class Main {
    public static void main(String[] args) {
        String[] ciudades = new String[]{"Londres", "Madrid", "Nueva York", "Buenos Aires",
                "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        int[][] temperaturas1 = new int[][]{
                {-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        String ciudadMax = "";
        String ciudadMin = "";
        for (int i = 0; i < ciudades.length; i++) {
            if (temperaturas1[i][1] > max) {
                max = temperaturas1[i][1];
                ciudadMax = ciudades[i];
            }
            if (temperaturas1[i][0] < min) {
                min = temperaturas1[i][0];
                ciudadMin = ciudades[i];
            }
        }
        System.out.println("La ciudad con la temperatura más alta es " + ciudadMax + " con " + max + " grados");
        System.out.println("La ciudad con la temperatura más baja es " + ciudadMin + " con " + min + " grados");
    }
}