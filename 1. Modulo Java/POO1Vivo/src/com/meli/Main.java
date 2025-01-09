package com.meli;

public class Main {

    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Daniel", 25, "1001199");
        Persona persona3 = new Persona("Juanito", 27, "123123", 74.2, 1.82);

        // Persona persona4 = new Persona("Pedro", 25);
        // Genera error ya que no tenemos ningun constructor que reciba solo nombre y edad de parametro
        // para corregirlo deberiamos crear otro constructor que reciba los atributos mencionados

        int imcType = persona3.calcularIMC();
        boolean isMayorEdad = persona3.esMayorDeEdad();

        if (imcType == -1) {
            System.out.println("Bajo peso");
        } else if (imcType == 0) {
            System.out.println("Peso saludable");
        } else {
            System.out.println("Sobrepeso");
        }

        if (isMayorEdad) {
            System.out.println(persona3.nombre + " es mayor de edad");
        } else {
            System.out.println(persona3.nombre + " es menor de edad");
        }

        System.out.println(persona3.toString());
    }
}
