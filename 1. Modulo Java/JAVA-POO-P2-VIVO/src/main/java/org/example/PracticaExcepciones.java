package org.example;

public class PracticaExcepciones {

    private int a = 0;
    private int b = 300;


    // punto 1
    public void cociente_v1() {
        int res;

        try {
            res = b / a;
        } catch (Exception e) {
            System.out.printf("Se ha producido un error: %s%n", e.getMessage());
        } finally {
            System.out.println("Programa finalizado");
        }

    }

    // punto 2
    public void cociente_v2() {
        int res;

        try {
            res = b / a;
        } catch (Exception e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }

    }
}


