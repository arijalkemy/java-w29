public class Main {
    public static void main(String[] args) {

        String ciudades[] = new String[10];
        int temperaturas[][] = new int[10][2];

        String ciudadMinimoTemperatura = "";
        int temperaturaMinima = 0;
        String ciudadMaximaTemperatura = "";
        int temperaturaMaxima = 0;

        ciudades[0] = "Londres";
        ciudades[1] = "Madrid";
        ciudades[2] = "Nueva York";
        ciudades[3] = "Buenos Aires";
        ciudades[4] = "Asunción";
        ciudades[5] = "São Paulo";
        ciudades[6] = "Lima";
        ciudades[7] = "Santiago de Chile";
        ciudades[8] = "Lisboa";
        ciudades[9] = "Tokio";
        temperaturas[0][0] = -2;
        temperaturas[0][1] = 33;
        temperaturas[1][0] = -3;
        temperaturas[1][1] = 32;
        temperaturas[2][0] = -8;
        temperaturas[2][1] = 27;
        temperaturas[3][0] = 4;
        temperaturas[3][1] = 37;
        temperaturas[4][0] = 6;
        temperaturas[4][1] = 42;
        temperaturas[5][0] = 5;
        temperaturas[5][1] = 43;
        temperaturas[6][0] = 0;
        temperaturas[6][1] = 39;
        temperaturas[7][0] = -7;
        temperaturas[7][1] = 26;
        temperaturas[8][0] = -1;
        temperaturas[8][1] = 31;
        temperaturas[9][0] = -10;
        temperaturas[9][1] = 35;

        for (int ciudad = 0; ciudad <10; ciudad++){
            System.out.println(ciudades[ciudad]);
            for (int temperatura = 0; temperatura <2; temperatura++){
                if(temperaturas[ciudad][temperatura] == temperaturas[ciudad][0]){
                    System.out.println("Temperatura minima: " + temperaturas[ciudad][temperatura]);
                    if (temperaturaMinima > temperaturas[ciudad][temperatura] ){
                        ciudadMinimoTemperatura = ciudades[ciudad];
                        temperaturaMinima = temperaturas[ciudad][temperatura];
                    }
                }
                else{
                    System.out.println("Temperatura maxima: " + temperaturas[ciudad][temperatura]);
                    if (temperaturaMaxima < temperaturas[ciudad][temperatura] ){
                        ciudadMaximaTemperatura = ciudades[ciudad];
                        temperaturaMaxima = temperaturas[ciudad][temperatura];
                    }
                }
            }
        }
        System.out.println(ciudadMinimoTemperatura + " tuvo la menor temperatura, con " + temperaturaMinima);
        System.out.println(ciudadMaximaTemperatura + " tuvo la mayor temperatura, con " + temperaturaMaxima);

    }
}


/*
String[] ciudades = {
                "Londres", "Madrid", "Nueva York",
                "Buenos Aires", "Asunción", "São Paulo",
                "Lima", "Santiago de Chile", "Lisboa", "Tokio"
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
*/