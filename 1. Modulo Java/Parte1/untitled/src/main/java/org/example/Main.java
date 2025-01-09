package org.example;

public class Main {
    public static void main(String[] args) {
        String[] ciudades={"Londres","Madrid","Nueva York","Buenos Aires","Asunción","São Paulo","Lima",
                "Santiago de Chile","Lisboa","Tokio"};
        Integer[][] temperaturas= {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        int indexMenorTemperatura=0;
        int indexMayorTemperatura=0;
        int mayorTemp=temperaturas[0][1];
        int menorTemp=temperaturas[0][0];
        System.out.println(temperaturas.length);
        System.out.println("La ciudad con menor temperatura fue: "+ ciudades[indexMenorTemperatura]+". " +
                "Registrando una temperatura minima de "+menorTemp+ " grados.");
        System.out.println("La ciudad con mayor temperatura fue: "+ ciudades[indexMayorTemperatura]+". " +
                "Registrando una temperatura maxima de "+mayorTemp+ " grados.");
       // for (int i=1;i<temperaturas.length;i++){

       // }

    }
}