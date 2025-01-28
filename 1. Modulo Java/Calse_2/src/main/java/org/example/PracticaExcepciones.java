package org.example;

public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public void calcularCociente() {
        try {
            // Intentamos calcular el cociente
            int cociente = b / a; // Esto puede lanzar ArithmeticException si a es 0
            System.out.println("El cociente es: " + cociente);
        } catch (ArithmeticException e) {
            // Si ocurre la excepción, lanzamos IllegalArgumentException
            throw new IllegalArgumentException("No se puede dividir por cero", e);
        }
    }

    public static void main(String[] args) {
        PracticaExcepciones practica = new PracticaExcepciones();

        try {
            practica.calcularCociente();
        } catch (IllegalArgumentException e) {
            // Capturamos la IllegalArgumentException y mostramos el mensaje
            System.out.println(e.getMessage());
        } finally {
            // Este bloque se ejecuta siempre, independientemente de si hubo error o no
            System.out.println("Programa finalizado");
        }
    }
}

