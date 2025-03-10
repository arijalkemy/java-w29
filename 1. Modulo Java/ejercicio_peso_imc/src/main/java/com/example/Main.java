package com.example;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();

        Persona persona2 = new Persona("Agostina", 22, "43123123");

        Persona persona3 = new Persona("Agostina", 22, "43123123", 55.0, 169.0);

        String[] listaIMC = {"Bajo peso", "Peso saludable", "Sobrepeso"};
        int IMC = persona3.calcularIMC();
        boolean esMayorDeEdad = persona3.esMayorDeEdad();

        System.out.printf("Nivel de peso de %s: %s%n", persona3.getNombre(), listaIMC[IMC + 1]);
        System.out.printf("Edad: %s%n", esMayorDeEdad ? "Mayor de edad" : "Menor de edad");
    }
}
