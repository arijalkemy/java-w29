package ejercicio_1;

public class Main {
    public static void main(String[] args) {
        PracticaExcepciones practica = new PracticaExcepciones();
        try {
            practica.calcularCociente();
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}