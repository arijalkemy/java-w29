package org;

public class Main {
    public static void main(String[] args) {
        // Crear objetos Persona usando diferentes constructores
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Juan", 25, "12345678");
        Persona persona3 = new Persona("Maria", 30, "87654321", 65.5, 1.7);

        // Probar construir con solo nombre y edad
        // Persona persona4 = new Persona("Carlos", 40); // Esto no es posible, falta dni
        // System.out.println(persona4); // Error de compilación

        // Calcular IMC y verificar mayoría de edad para persona3
        System.out.println("\nDatos de la persona:");
        System.out.println(persona3);

        int imcResultado = persona3.calcularIMC();
        if (imcResultado == -1) {
            System.out.println("La persona tiene bajo peso.");
        } else if (imcResultado == 0) {
            System.out.println("La persona tiene un peso saludable.");
        } else {
            System.out.println("La persona tiene sobrepeso.");
        }

        if (persona3.esMayorDeEdad()) {
            System.out.println("La persona es mayor de edad.");
        } else {
            System.out.println("La persona es menor de edad.");
        }
    }
}