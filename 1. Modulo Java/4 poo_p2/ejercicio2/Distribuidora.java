import java.util.*;

public class Distribuidora {
  public static void main(String[] args) {
    List<Producto> productos = new ArrayList<>(List.of(
      new Perecedero("Leche", 1.5, 1),
      new Perecedero("Pan", 0.5, 2),
      new Perecedero("Huevos", 3.0, 3),
      new Perecedero("Carne", 5.0, 4),
      new Perecedero("Pescado", 4.0, 5),
      new NoPerecedero("Arroz", 2.0, "Grano"),
      new NoPerecedero("Frijoles", 1.5, "Grano"),
      new NoPerecedero("Aceite", 3.0, "Líquido"),
      new NoPerecedero("Azúcar", 1.0, "Grano"),
      new NoPerecedero("Sal", 0.5, "Grano")
    ));
    double total = 0;
    for(Producto producto : productos) {
      // System.out.println(producto);
      total += producto.calcular(2);
    }
    System.out.println("Total: " + total);
  }

  // public void vender() {
  //   double precioTotal = productos.parallelStream()
  //           .map(producto -> producto.calcular(5))
  //           .reduce(0.0, Double::sum);
  //   System.out.printf("El precio total de los productos es $%s%n", precioTotal);
  // }
}
