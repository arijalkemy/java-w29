package Poo.ejercicio_1;

public class PracticaExcepciones {

    private int a = 0;
    private int b = 300;

    public void calcularCociente() {
        try {
            int c = b / a;
            System.out.println("El cociente es: " + c);
        } catch (Exception e) {
            throw new IllegalArgumentException("No se puede dividir por cero.");
        } finally {
            System.out.println("Programa finalizado.");
        }
    }
}
