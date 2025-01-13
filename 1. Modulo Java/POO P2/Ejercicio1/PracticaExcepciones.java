package Ejercicio1;
public class PracticaExcepciones {
    public int a;
    public int b;

    public PracticaExcepciones(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public void division() {
        try {
            System.out.println("Resultado: " + (this.a/this.b));
        }catch (Exception e) {
            throw new IllegalArgumentException("No se acepta division entre cero");
        }
    }

    

}
