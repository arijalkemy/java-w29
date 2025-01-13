package Ejercicio1;
public class Main {
    public static void main(String[] args) {
        
        PracticaExcepciones practica = new PracticaExcepciones(300,0);

        try {
            practica.division();
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
