package com.thiagoschreck.local.excepciones;

public class PracticaExcepciones {

    public void calcularCoeficienteAB() {
        try {
            int a = 0;
            int b = 300;
            int q = b / a;
            System.out.printf("El coeficiente es %s%n", q);
        } catch (Exception e) {
            // System.out.printf("Se ha producido un error: %s%n", e.getMessage());
            throw new IllegalArgumentException("No se puede dividir entre cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
