public class Main {
    public static void main(String[] args) {
        String [] ciudades= { "Londres", "Madrid", "Nueva York", "Buenos Aires",
                "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        int [][] temperaturas = {
                {-2,33},
                {-3,32},
                {-8,27},
                {4,37},
                {6,42},
                {5,43},
                {0,39},
                {-7,26},
                {-1,31},
                {-10,35}
        };

        int tempMenor = temperaturas[0][0];
        int tempMayor = temperaturas[0][1];
        int indiceMenor = 0;
        int indiceMayor = 0;

        for (int i = 1; i < temperaturas .length; i++) {
            if (temperaturas[i][0] < tempMenor) {
                tempMenor = temperaturas[i][0];
                indiceMenor = i;
            }

            if (temperaturas[i][1] > tempMayor) {
                tempMayor = temperaturas[i][1];
                indiceMayor = i;
            }
        }

        System.out.println("la ciudad con menor temperatura es " + ciudades[indiceMenor] + " con una temperatura de " + tempMenor);
        System.out.println("la ciudad con mayor temperatura es " + ciudades[indiceMayor] + " con una temperatura de " + tempMayor);

    }
}