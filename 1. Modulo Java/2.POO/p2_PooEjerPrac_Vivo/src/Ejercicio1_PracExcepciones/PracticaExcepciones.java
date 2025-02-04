package Ejercicio1_PracExcepciones;

public class PracticaExcepciones {
    //No se puede dividir por 0
    private int a = 2;
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
