package com.mdaneri;

public class PracticaExcepciones {

    private int a;
    private int b;

    public PracticaExcepciones() {
        this.a = 0;
        this.b = 300;
    }

    public double calcularCociente1() {
        return b / a;
    }

    public double calcularCociente2() throws IllegalArgumentException {
        if (a == 0)
            throw new IllegalArgumentException("No se puede dividir por cero");
        return b / a;
    }

    public static void main(String[] args) {
        PracticaExcepciones p = new PracticaExcepciones();

        // Ejercicio 1: Controlar la excepción que se lanza indicando el mensaje “Se ha producido un error”. Al final del programa siempre deberá indicar el mensaje “Programa finalizado”
        try {
            p.calcularCociente1();
            System.out.println("El resultado es: " + p.calcularCociente1());
        } catch (ArithmeticException e) {
            System.out.println("Se ha producido un error: " + e.getMessage());
        } finally {
            System.out.println("Programa finalizado");
        }

        // Ejercicio 2: Al producirse el error, en vez de imprimir por consola el mensaje “Se ha producido un error”, lo lance como una excepción de tipo IllegalArgumentException con el mensaje “No se puede dividir por cero”
        p.calcularCociente2();

    }

}
