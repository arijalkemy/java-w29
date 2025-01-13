package ejercicio1;

public class PracticaExcepciones {
    public static void main(String[] args) {

        int a = 0;
        int b = 300;

        calcularCociente(a, b);
        calcularCocienteConExcepcion(a, b);

    }

    public static void calcularCociente(int a, int b) {
        try {
            int resultado = b / a;
            System.out.println("El resultado es: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Se ha producido un error");
        } finally {
            System.out.println("Programa finalizado");
        }
    }

    public static void calcularCocienteConExcepcion(int a, int b) {
        try {
            if (a == 0) {
                throw new IllegalArgumentException("No se puede dividir por cero");
            }
            int resultado = b / a;
            System.out.println("El resultado es: " + resultado);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
