package org.example;

import org.example.Model.Persona;

//Ejercicio 3
public class Main {
    public static void main(String[] args) {

        //Ejercicio 4

        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Caro", 33, "44690195");
        Persona persona3 = new Persona("Ori", 17, "16386399", 1.60, 50);

        /*
        A continuación vamos a crear otro objeto de tipo persona y vamos a
        construirlo pasando solamente un valor para el nombre y otro para la edad en el constructor.
        ¿Es esto posible? ¿Qué sucede si tratamos de hacer esto?

        Con los constructores que tenemos, eso es imposible de hacer dado que los constructores necesitan de otros parametros. Existe una manera de
        hacerlo con un builder y asi construir los objetos que nosotros quisieramos.
        */

        System.out.println("IMC de " + persona3.getName() + " : " + persona3.calcularIMC());

        //Ejercicio 6

        Persona persona4 = new Persona("Pablo", 33, "12345678", 1.85, 98);

        int imcResultado = persona4.calcularIMC();
        String imcMensaje = switch (imcResultado) {
            case -1 -> "Bajo peso";
            case 0 -> "Peso saludable";
            case 1 -> "Sobrepeso";
            default -> "Error al calcular el IMC.";
        };

        boolean esMayorDeEdad = persona4.esMayorDeEdad();
        String mensajeMayorDeEdad = esMayorDeEdad ? "Es mayor de edad." : "No es mayor de edad.";

        System.out.println("---- Informacion de la Persona ----");
        System.out.println(persona4);
        System.out.println("IMC: " + imcMensaje);
        System.out.println(mensajeMayorDeEdad);

    }
}