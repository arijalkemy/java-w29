import java.util.ArrayList;
import java.util.Random;

public class Distribuidora {

  public static void main(String[] args) {
    Random random = new Random();
    ArrayList<Producto> listaProductos = new ArrayList<>();
    double precioTotal = 0;
    Perecedero banano = new Perecedero("Banano", 500, 1);
    Perecedero carne = new Perecedero("Carne", 1500, 2);
    NoPerecedero cuaderno = new NoPerecedero("Cuaderno", 100, "Útiles escolares");
    NoPerecedero lapicero = new NoPerecedero("Lapicero", 500, "Útiles escolares");
    listaProductos.add(banano);
    listaProductos.add(carne);
    listaProductos.add(cuaderno);
    listaProductos.add(lapicero);
    for (Producto producto: listaProductos) {
      int cantidadProducto = random.nextInt(10);
      System.out.println("Producto: " + producto.getNombre() + ", cantidad: " + cantidadProducto);
      precioTotal = precioTotal + producto.calcular(cantidadProducto);
    }
    System.out.println("El precio total es: " + precioTotal);
  }
}
