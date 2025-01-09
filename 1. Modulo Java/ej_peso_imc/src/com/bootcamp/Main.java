package com.bootcamp;

public class Main {

    public static void main(String[] args) {
        Persona german = new Persona();
        Persona alfredo = new Persona("Alfredo", 43, "25009876");
        Persona jazmin = new Persona("Jazmin", 37, "34123234", 50, 1.55);

        int imcResultado = jazmin.calcularIMC();
        String imcMensaje = switch (imcResultado) {
            case -1 -> "Bajo peso";
            case 0 -> "Peso saludable";
            case 1 -> "Sobrepeso";
            default -> "Error al calcular el IMC.";
        };

        boolean esMayorDeEdad = jazmin.esMayorDeEdad();
        String mensajeMayorDeEdad = esMayorDeEdad ? "Es mayor de edad." : "No es mayor de edad.";

        System.out.println("---- Informacion de la Persona ----");
        System.out.println(jazmin);
        System.out.println("IMC: " + imcMensaje);
        System.out.println(mensajeMayorDeEdad);
    }
}
