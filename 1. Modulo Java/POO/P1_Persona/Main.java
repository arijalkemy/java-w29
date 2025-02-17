package com.example.demo.POO.P1_Persona;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Eliseo", 21,"44690195");
        Persona persona3 = new Persona("Mabel",60, "16386399", 1.60, 50);
        /*
        Ejercicio 4 - Design pattern: Builder:
        A continuación vamos a crear otro objeto de tipo persona y vamos a
        construirlo pasando solamente un valor para el nombre y otro para la edad en el constructor.
        ¿Es esto posible? No (Con lo que tenemos no). ¿Qué sucede si tratamos de hacer esto? Una combinatoria de ctores.
        */

        Persona p = new Persona.PersonaBuilder().setName("Hola").setAge(21).build();
        System.out.println(p);

        /*
        Ejercicio 5 - IMC
         */
        //System.out.println(persona3);
        System.out.println("IMC de " + persona3.getName() + " : " + persona3.calcularIMC());
        /*
        Ejercicio 6
        */
        Persona persona = new Persona("Eliseo", 21, "12345678", 1.75, 70);

        int imcResultado = persona.calcularIMC();
        String imcMensaje = switch (imcResultado) {
            case -1 -> "Bajo peso";
            case 0 -> "Peso saludable";
            case 1 -> "Sobrepeso";
            default -> "Error al calcular el IMC.";
        };

        boolean esMayorDeEdad = persona.esMayorDeEdad();
        String mensajeMayorDeEdad = esMayorDeEdad ? "Es mayor de edad." : "No es mayor de edad.";

        System.out.println("---- Informacion de la Persona ----");
        System.out.println(persona);
        System.out.println("IMC: " + imcMensaje);
        System.out.println(mensajeMayorDeEdad);

    }

}


