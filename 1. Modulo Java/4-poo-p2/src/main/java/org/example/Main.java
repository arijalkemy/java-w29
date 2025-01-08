package org.example;

public class Main {
    public static void main(String[] args) {
        // Ejercicio 1.1
        PracticaExcepciones p = new PracticaExcepciones(0, 300);

        try{
            System.out.println("Resultado: " + p.calcularCociente());
        } catch (Exception e) {
            System.out.println("Se ha producido un error");
        } finally {
            System.out.println("Programa finalizado");
        }

        // Ejercicio 1.2
        try{
            if(p.getA() == 0) {
                throw new IllegalArgumentException("No se puede dividir por 0");
            }
            System.out.println("Resultado: " + p.calcularCociente());
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}