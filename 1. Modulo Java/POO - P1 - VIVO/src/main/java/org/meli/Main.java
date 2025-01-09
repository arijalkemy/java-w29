package org.meli;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();

        Persona persona2 = new Persona("Carolina", 21, "44556677", 50, 1.55);

        Persona persona3 = new Persona("Carolina", 21, "44556677");

        //Persona persona4 = new Persona("Carolina", 21);
        // Da error ya que no existe un Constructor que reciba estos parámetros

        System.out.println(persona2.toString());
        System.out.println("El nivel de peso es: " + persona2.IMCSalud());
        System.out.println("¿Es mayor de edad? " + persona2.esMayor());
        System.out.println(persona2.mostrarCalculo());
    }
}