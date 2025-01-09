public class PracticaExcepciones {
    public static void main(String[] args) {
        int a = 0;
        int b = 300;
        try {
            int c = b / a;
        } catch (ArithmeticException e){
            //throw new IllegalArgumentException("No se puede dividir por cero");
            System.out.println("Error en la division: " + e.getMessage());
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
