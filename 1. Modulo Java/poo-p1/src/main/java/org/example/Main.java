package org.example;

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona("pepe", 25, "1231233", 90.0F, 1.80F);
        System.out.println(persona.esMayorDeEdad() ? "La persona es mayor de edad" : "La persona no es mayor de edad");

        switch (persona.calcularIMC()) {
            case -1:
                System.out.println("Bajo peso");
                break;
            case 0:
                System.out.println("Saludable");
                break;
            case 1:
                System.out.println("Sobrepeso");
                break;
        }

        System.out.println(persona);
    }
}