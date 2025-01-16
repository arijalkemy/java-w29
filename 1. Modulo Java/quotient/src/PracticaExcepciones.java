public class PracticaExcepciones {
    private int a;
    private int b;

    public PracticaExcepciones() {
        this.a = 0;
        this.b = 300;
    }

    public void getQuotient() {
        try {
            double quotient = b / a;
            System.out.println("The quotient is " + quotient + ".");
        } catch (ArithmeticException exception) {
            // System.out.println("Se ha producido un error.");
            throw new IllegalArgumentException("No se puede dividir por cero.");
        } finally {
            System.out.println("Programa finalizado.");
        }
    }
}