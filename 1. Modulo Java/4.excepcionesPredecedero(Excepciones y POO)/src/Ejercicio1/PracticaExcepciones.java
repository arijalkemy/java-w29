package Ejercicio1;

public class PracticaExcepciones {

    public static void main(String[] args) {
        int a = 0;
        int b = 300;

        try {
            if (a == 0) {
                // Lanzar una excepción personalizada si a es 0
                throw new IllegalArgumentException("No se puede dividir por cero");
            }
            int resultado = b / a;
            System.out.println("El resultado de la división es: " + resultado);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}

