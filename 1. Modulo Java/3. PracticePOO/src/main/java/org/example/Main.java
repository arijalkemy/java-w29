package org.example;

public class Main {
    public static void main(String[] args) {
        Persona personaVacia = new Persona();
        Persona personaNombre = new Persona("Persona1", 20, "A21S");
        Persona personaCompleta = new Persona("Persona2", 30, "DLS123", 62.3, 1.65);

        int imc = personaCompleta.calcularIMC();
        if (imc == -1)
            System.out.println("(IMC): Bajo peso");
        else if (imc == 0)
            System.out.println("(IMC): Peso Saludable");
        else
            System.out.println("(IMC): Sobrepeso");
        if (personaCompleta.esMayorDeEdad())
            System.out.println("Es mayor de edad");
        else
            System.out.println("No es mayor de edad");

        System.out.println(personaCompleta.toString());

    }
}