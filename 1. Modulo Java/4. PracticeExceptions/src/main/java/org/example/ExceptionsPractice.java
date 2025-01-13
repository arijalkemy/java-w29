package org.example;

public class ExceptionsPractice {

    // Attributes
    private int a = 0;
    private int b = 300;

    // Constructor
    public ExceptionsPractice() {
    }

    // Methods
    public void coefficientCalculation() {
        try {
            int quotient = b / a;
            System.out.println("El cociente es: " + quotient);
        } catch (ArithmeticException e) {
            System.out.println("Se ha producido un error");
            //throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
