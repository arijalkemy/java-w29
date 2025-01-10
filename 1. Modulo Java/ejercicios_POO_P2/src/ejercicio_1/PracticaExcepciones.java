package ejercicio_1;

public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public void calcularCociente(){
        try {
            int cociente = b/a;
            System.out.println("El cociente es: " + cociente);
        } catch(ArithmeticException e){
            throw new IllegalArgumentException("No se puede dividir por cero" , e);
        } finally {
            System.out.println("Programa finalizado");
        }

    }
};


