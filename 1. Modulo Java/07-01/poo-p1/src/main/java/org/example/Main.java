package org.example;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Sofía", 21, "46026532");
        Persona persona3 = new Persona("Martín", 23, "43571203", 79.15, 1.90);

        int imc = persona3.calcularIMC();
        boolean esMayorDeEdad = persona3.esMayorDeEdad();
        String mensajeIMC;
        switch (imc) {
            case -1 -> mensajeIMC = "Bajo peso";
            case 0 -> mensajeIMC = "Peso saludable";
            case 1 -> mensajeIMC = "Sobrepeso";
            default -> mensajeIMC = "No fue posible calcular el IMC";
        }
        System.out.println(mensajeIMC);
    }
}