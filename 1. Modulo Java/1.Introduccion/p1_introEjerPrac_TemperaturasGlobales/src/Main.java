public class Main {

    public static void main(String[] args) {

        String[] ciudad = {
                "Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "Sao Paulo", "Lima",
                "Santiago de Chile", "Lisboa", "Tokio"
        };

        int[][] temperatura = {
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

        int menor = 0;
        int mayor = 0;

        for (int i = 0; i < ciudad.length; i++) {
            if (temperatura[i][0] < temperatura[menor][0]) menor = i;
            if (temperatura[i][1] > temperatura[mayor][1]) mayor = i;
        }

        System.out.printf("Temperatura mínima: %s | %d°%n", ciudad[menor], temperatura[menor][0]);
        System.out.printf("Temperatura máxima: %s | %d°%n", ciudad[mayor], temperatura[mayor][0]);
    }
}