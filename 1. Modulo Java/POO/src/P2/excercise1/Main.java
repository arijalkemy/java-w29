package P2.excercise1;

import P2.excercise1.domain.PracticaExcepciones;

public class Main {
    public static void main(String[] args) {
        try {
            PracticaExcepciones practicaExcepciones = new PracticaExcepciones();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Programa finalizado");
    }
}
