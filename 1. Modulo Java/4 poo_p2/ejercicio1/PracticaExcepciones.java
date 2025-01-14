package poo_p2_e1;

public class PracticaExcepciones {
  private static int a = 0;
  private static int b = 300;

  static double division() {
    try{
      return b / a;
    } catch (ArithmeticException e) {
      throw new IllegalArgumentException("No se puede dividir por cero");
    }
  }
}