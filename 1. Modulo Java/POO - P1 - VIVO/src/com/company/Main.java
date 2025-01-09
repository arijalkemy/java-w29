package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Pablo", 23, 43498923);
        Persona persona3 = new Persona("Joaquin", 22, 43494583, 60.8, 1.85);

        switch (persona3.getIMC()){
            case -1:
                System.out.println("Bajo Peso");
                break;
            case 0:
                System.out.println("Peso Saludable");
                break;
            default:
                System.out.println("Sobrepeso");
                break;
        }

        if (persona3.esMayorDeEdad()){
            System.out.println("Es mayor de edad");
        }
        else{
            System.out.println("Es menor de edad");
        }

        System.out.println(persona3.toString());
    }
}