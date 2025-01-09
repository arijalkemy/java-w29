public class PracticaExcepciones {
  private int a, b;

  public PracticaExcepciones(int a, int b) {
    this.a = a;
    this.b = b;
  }

  public void calcularCociente() {
    try {
      double cociente = b/a;
    } catch (ArithmeticException ex) {
      throw new IllegalArgumentException("No se puede dividir por cero");
    } finally {
      System.out.println("Programa finalizado");
    }
  }
}