package org.example;

public class Main {
    // Ejercicio 3
    public static void main(String[] args) {
        // Ejercicio 4
        Persona personaUno = new Persona();
        Persona personaDos = new Persona("Eliana", 26, "00000000");
        Persona personaTres = new Persona("Lara", 17, "00000001", 50.0, 1.70);

        // Ejercicio 6
        switch (personaTres.calcularIMC()){
            case -1:
                System.out.println("Bajo peso");
                break;
            case 0:
                System.out.println("Peso saludable");
                break;
            case 1:
                System.out.println("Sobrepeso");
                break;
            default:
                break;
        }

        if(personaTres.esMayorDeEdad()){
            System.out.println("La persona es mayor de edad");
        } else {
            System.out.println("La persona es menor de edad");
        }
    }
}