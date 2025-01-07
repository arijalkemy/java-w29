public class Main {
    public static void main(String[] args) {
        PracticaExcepciones practicaExcepciones = new PracticaExcepciones();

        try {
            practicaExcepciones.calcDiv();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("Programa finalizado");

    }
}
