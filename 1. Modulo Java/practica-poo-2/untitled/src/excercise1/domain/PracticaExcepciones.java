package excercise1.domain;

public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public PracticaExcepciones(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public PracticaExcepciones(){
        try {
            int cociente = this.b/this.a;
        } catch (Exception e) {
            throw new IllegalArgumentException("No se puede dividir entre cero");
        }
    }
}
