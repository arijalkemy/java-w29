package org.example;

public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public void calcularCociente() {
        try {
            int cociente = b / a;
            System.out.println("El cociente es: " + cociente);
        } catch (ArithmeticException e) {
            System.out.println("Se ha producido un error");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
    public void calcularCociente2() { try {
        int cociente = b / a;
        System.out.println("El cociente es: " + cociente);
    } catch (IllegalArgumentException e) {

        System.out.println(e.getMessage()); // Imprimir mensaje de la excepción
        throw  e;
    } finally {
        System.out.println("Programa finalizado");
    }
    }


    public static void main(String[] args) {
        PracticaExcepciones practica = new PracticaExcepciones();
        practica.calcularCociente2();
    }
}



















// Throws
