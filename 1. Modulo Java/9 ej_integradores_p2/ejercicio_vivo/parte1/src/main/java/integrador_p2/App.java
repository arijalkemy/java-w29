package integrador_p2;

import java.util.*;

public class App {
    public static void main(String[] args) {
      GuardaRopa guardaRopa = new GuardaRopa();
      Integer codigo = guardaRopa.guardarPrendas(List.of(
        new Prenda("Nike", "Air Max"),
        new Prenda("Adidas", "Superstar")
      ));
      System.out.println("Codigo de almacenamiento: " + codigo);
      guardaRopa.mostrarPrendas();
    }
}
