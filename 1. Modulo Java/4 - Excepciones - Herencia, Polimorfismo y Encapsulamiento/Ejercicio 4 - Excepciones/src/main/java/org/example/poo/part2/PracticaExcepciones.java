package org.example.poo.part2;

public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public void division() {
        //Ejercicio 1
        try {
            System.out.println("La division de B / A es: " + b / a);
        } catch (Exception e) {
            //System.out.println("Se ha producido un error");

            //Ejercicio 2
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
