public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public void calcularCociente() {
        try {
            int cociente = b / a;
            System.out.println("El cociente de " + b + " / " + a + " es: " + cociente);
        } catch (ArithmeticException e) {
            throw  new IllegalArgumentException("Se ha producido un error");
            //throw new IllegalArgumentException("No se puede dividir por cero",e);
        }
        finally {
            System.out.println("Programa finalizado");
        }

        throw new IllegalArgumentException("No se puede dividir por cero");
    }
}