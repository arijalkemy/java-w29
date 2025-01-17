package org.example.poo;

//Ejercicio 3
public class Main {
    public static void main(String[] args) {
        //Ejercicio 4.1
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Juan", 25, "12345678");
        Persona persona3 = new Persona("Pedro", 30, "87654321", 70.5, 1.75);

        //Ejercicio 4.2
        //Persona persona4 = new Persona("Luis", 40);
        //Sucede un error porque no existe un constructor que reciba solo nombre y edad.

        //Ejercicio 6
        System.out.println(persona2.toString());
        System.out.println();

        int imc = persona2.cacularIMC();
        switch (imc){
            case -1 -> {
                System.out.println("Índice de masa corporal (IMC): Por debajo de 20");
                System.out.println("Nivel de peso: Bajo peso \n");
            }
            case 0 -> {
                System.out.println("Índice de masa corporal (IMC): Entre 20 y 25 inclusive");
                System.out.println("Nivel de peso: Peso saludable \n");
            }
            case 1 -> {
                System.out.println("Índice de masa corporal (IMC): Mayor a 25");
                System.out.println("Nivel de peso: Sobrepeso \n");
            }
        }

        boolean esMayorDeEdad = persona3.esMayorDeEdad();
        if (esMayorDeEdad){
            System.out.println("Es mayor de edad \n");
        } else {
            System.out.println("Es menor de edad \n");
        }
    }
}