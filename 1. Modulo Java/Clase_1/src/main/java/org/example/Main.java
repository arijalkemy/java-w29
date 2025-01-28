package org.example.clases1;

import org.example.clases1.Persona;

public class Main {
    public static void main(String[] args) {
        // Usando el constructor sin parámetros
        Persona persona1 = new Persona();

        // Usando el constructor que recibe nombre, edad y dni
        Persona persona2 = new Persona("Juan", 25, "12345678");

        // Usando el constructor que recibe todos los atributos
        Persona persona3 = new Persona("Maria", 30, "87654321", 70.0, 1.75);

        // Intento de crear otro objeto pasando solo nombre y edad
        // Esto no funcionará porque no hay un constructor que solo reciba esos dos.
        // Persona persona4 = new Persona("Ana", 22); // Esto generará un error.

        // Verifica el resultado
        System.out.println(persona2.getNombre()); // Juan
        System.out.println(persona3.getDni()); // 87654321

        int resultadoIMC = persona3.calcularIMC();
        String mensajeIMC = "";
        switch (resultadoIMC) {
            case -1:
                mensajeIMC = "Bajo peso";
                break;
            case 0:
                mensajeIMC = "Peso saludable";
                break;
            case 1:
                mensajeIMC = "Sobrepeso";
                break;
            default:
                mensajeIMC = "No se pudo calcular el IMC";
        }

        // Verificar si es mayor de edad
        boolean esMayorDeEdad = persona3.esMayorDeEdad();
        String mensajeEdad = esMayorDeEdad ? "Es mayor de edad." : "No es mayor de edad.";

        // Imprimir información de la persona
        System.out.println(persona3.toString());
        System.out.println("IMC: " + mensajeIMC);
        System.out.println(mensajeEdad);
    }
}
