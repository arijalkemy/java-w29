package org.example;

public class Main {
    public static void main(String[] args) {
        //Cargo ciudades
        String cities[] = new String[10];
        cities[0] = "Londres";
        cities[1] = "Madrid";
        cities[2] = "Nueva York";
        cities[3] = "Buenos Aires";
        cities[4] = "Asuncion";
        cities[5] = "Sao Paulo";
        cities[6] = "Lima";
        cities[7] = "Santiago";
        cities[8] = "Lisboa";
        cities[9] = "Tokio";

        int tempBajasyAltas[][] = new int[10][2];
        //Cargo Minimos
        tempBajasyAltas[0][0] = -2;
        tempBajasyAltas[1][0] = -3;
        tempBajasyAltas[2][0] = -8;
        tempBajasyAltas[3][0] = 4;
        tempBajasyAltas[4][0] = 6;
        tempBajasyAltas[5][0] = 5;
        tempBajasyAltas[6][0] = 0;
        tempBajasyAltas[7][0] = -7;
        tempBajasyAltas[8][0] = -1;
        tempBajasyAltas[9][0] = -10;
        //Cargo Maximas
        tempBajasyAltas[0][1] = 33;
        tempBajasyAltas[1][1] = 32;
        tempBajasyAltas[2][1] = 27;
        tempBajasyAltas[3][1] = 37;
        tempBajasyAltas[4][1] = 42;
        tempBajasyAltas[5][1] = 43;
        tempBajasyAltas[6][1] = 39;
        tempBajasyAltas[7][1] = 26;
        tempBajasyAltas[8][1] = 31;
        tempBajasyAltas[9][1] = 35;

        int minTemp = tempBajasyAltas[0][0];
        int maxTemp = tempBajasyAltas[0][1];
        int indexMin = 0;
        int indexMax = 0;

        for(int i=1; i<tempBajasyAltas.length; i++){
            if(tempBajasyAltas[i][0]<minTemp){
                minTemp=tempBajasyAltas[i][0];
                indexMin = i;
            }
            if(tempBajasyAltas[i][1]>maxTemp){
                maxTemp=tempBajasyAltas[i][1];
                indexMax = i;
            }
        }

        System.out.println("La temperatura minima registrada fue: " + minTemp + " y fue en la ciudad de: " + cities[indexMin]);
        System.out.println("La temperatura maxima registrada fue: " + maxTemp + " y fue en la ciudad de: " + cities[indexMax]);
    }

}