package org.example;

public class Main {
    public static void main(String[] args) {
        //DEFINIR VECTOR DE CIUDADES.
        String ciudades[] = new String[10];
        //DEFINIR MATRIZ DE temperaturasERATIREAS
        double temperaturas[][] = new double[10][2];

        //cargar los datos de las ciudades
        ciudades[0] = "Londres";
        ciudades[1] = "Madrid";
        ciudades[2] = "Nueva York ";
        ciudades[3] = "Buenos Aires";
        ciudades[4] = "Asución";
        ciudades[5] = "Sao Pablo";
        ciudades[6] = "Lima";
        ciudades[7] = "Santiago de chile";
        ciudades[8] = "Lisboa";
        ciudades[9] = "Tokio";

        //cargar los datos de temperaturas correspondientes a ciudades
        temperaturas[0][0]=-2;
        temperaturas[0][1]=33;
        temperaturas[1][0]=-3;
        temperaturas[1][1]=32;
        temperaturas[2][0]=-8;
        temperaturas[2][1]=27;
        temperaturas[3][0]=4;
        temperaturas[3][1]=37;
        temperaturas[4][0]=6;
        temperaturas[4][1]=42;
        temperaturas[5][0]=5;
        temperaturas[5][1]=43;
        temperaturas[6][0]=0;
        temperaturas[6][1]=39;
        temperaturas[7][0]=-7;
        temperaturas[7][1]=26;
        temperaturas[8][0]=-1;
        temperaturas[8][1]=31;
        temperaturas[9][0]=-10;
        temperaturas[9][1]=35;

        //definir variables para almacenar temperaturas maximas y minimas y la ciudad correpondiente
        double tempmin = temperaturas[0][0];
        double tempmax = temperaturas[0][0];
        String ciudmin = ciudades[0];
        String ciudmax= ciudades[0];

        //Recorrer matriz de temperatura para obtener la maxima y la mina y la ciudad a la que correponde cada una
        for(int i=0;i<10;i++){
            for (int j=0; j<2;j++){

                if(tempmin>temperaturas[i][0]){
                    tempmin= temperaturas[i][j];
                    ciudmin= ciudades[i];
                }

                if(tempmax<temperaturas[i][1]){
                    tempmax = temperaturas[i][j];
                    ciudmax=ciudades[i];
                }

            }
        }

        System.out.println("La menor temperatura la tuvo " +ciudmin+ ",con " +tempmin +"°C");
        System.out.println("La mayor temperatura la tuvo " +ciudmax+ ",con " +tempmax +"°C");


    }
}