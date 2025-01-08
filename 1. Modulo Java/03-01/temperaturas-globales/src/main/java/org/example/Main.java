package org.example;

public class Main {
    public static void main(String[] args) {
        String[] ciudades =     {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "Saõ Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperaturas =  {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        int tempMaxIndex = 0;
        int tempMinIndex = 0;

        for (int i = 0; i < temperaturas.length; i++) {
                    tempMinIndex = (temperaturas[i][0] < temperaturas[tempMinIndex][0]) ? i : tempMinIndex;
                    tempMaxIndex = (temperaturas[i][1] > temperaturas[tempMaxIndex][1]) ? i : tempMaxIndex;
        }

        System.out.printf("la menor temperatura la tuvo %s, con %d º C.", ciudades[tempMinIndex], temperaturas[tempMinIndex][0]);
        System.out.println();
        System.out.printf("la mayor temperatura la tuvo %s, con %d º C.", ciudades[tempMaxIndex], temperaturas[tempMaxIndex][1]);
    }
}