public class PracticaExcepciones {
    int a = 0;
    int b = 300;

    public void calcularCociente() {
        try {
            int cociente = b / a;
            System.out.println("El cociente de " + b + " / " + a + " es: " + cociente);

        //Controlar la excepción que se lanza indicando el mensaje “Se ha producido un error”
        /*
        } catch (Exception e) {
            System.out.println("se ha producido un error" + e.getMessage());
        }
        */

        //excepción de tipo IllegalArgumentException con el mensaje “No se puede dividir por cero”
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("No se puede dividir por cero" + e.getMessage());
        }
        finally {
            System.out.println("Programa finalizado");
        }
    }
}