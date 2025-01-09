package main;

import entity.Persona;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Juan", 25, "12345678");
        Persona persona3 = new Persona("Ana", 30, "87654321", 65.0, 1.70);
        // No es posible crear un objeto de tipo Persona pasando solo nombre y edad
        // Persona persona4 = new Persona("Carlos", 40); // Esto causaría un error de compilación

        int imc = persona3.calcularIMC();
        switch (imc){
            case -1:
                System.out.println("La persona tiene bajo peso.");
                break;
            case 0:
                System.out.println("La persona tiene peso normal.");
                break;
            case 1:
                System.out.println("La persona tiene sobrepeso.");
                break;
        }

        if (persona3.esMayorDeEdad()) {
            System.out.println("La persona es mayor de edad.");
        } else {
            System.out.println("La persona es menor de edad.");
        }

        System.out.println(persona3.toString());
    }
}