package org.example;


public class Main {
    public static void main(String[] args) {

        Persona personaSinDatos = new Persona();
        Persona personaNombreEdadDni = new Persona("Carlos", "25", "12345678");
        Persona personaCompleta = new Persona("Ana", "30", "37654321", 70.0, 1.75);

        System.out.println("Persona sin datos:");
        System.out.println(personaSinDatos.toString());

        System.out.println("\nPersona con nombre, edad y DNI:");
        System.out.println(personaNombreEdadDni.toString());

        System.out.println("\nPersona completa:");
        System.out.println(personaCompleta.toString());

        double imc = personaCompleta.calcularIMC();
        System.out.println("\nIMC de persona completa: " + imc);


        if (imc == -1) {
            System.out.println("Nivel de peso: Bajo peso");
        } else if (imc == 0) {
            System.out.println("Nivel de peso: Peso saludable");
        } else {
            System.out.println("Nivel de peso: Sobrepeso");
        }


        boolean esMayor = personaCompleta.esMayorDeEdad();
        if (esMayor) {
            System.out.println("La persona es mayor de edad.");
        } else {
            System.out.println("La persona es menor de edad.");
        }

        System.out.println("\nInformación completa de la persona:");
        System.out.println(personaCompleta.toString());
    }
    }







