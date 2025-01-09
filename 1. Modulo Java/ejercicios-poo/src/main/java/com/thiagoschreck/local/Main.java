package com.thiagoschreck.local;

public class Main {
    public static void main(String[] args) {
        Persona personaSinDatos = new Persona();
        Persona personaDatosBasicos = new Persona("Johnny Test", 23, "1.234.567-8");
        Persona personaDatosCompletos = new Persona("Johnny Test", 23, "1.234.567-8", 80, 1.81);

        int imc = personaDatosCompletos.calcularIMC();
        String mensajeIMC = "Sobrepeso";

        if (imc == -1) {
            mensajeIMC = "Bajo peso";
        }
        if (imc == 0) {
            mensajeIMC = "Peso saludable";
        }

        System.out.printf("El IMC de %s es: %s.%n", personaDatosCompletos.getNombre(), mensajeIMC);
        System.out.printf("%s%s es mayor de edad.", personaDatosCompletos.getNombre(), personaDatosCompletos.esMayorDeEdad() ? "" : " no");
    }
}