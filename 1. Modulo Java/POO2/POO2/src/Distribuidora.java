import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Perecedero("Leche", 2500.50, 1));
        productos.add(new Perecedero("Yogurt", 3000.0, 2));
        productos.add(new NoPerecedero("Arroz", 2450.0, "se"));
        productos.add(new NoPerecedero("Lentejas", 1200.99, "no "));

        for (Producto producto : productos) {
            System.out.println(producto);
            System.out.println("Precio total por 5 productos: " + producto.calcular(5));
        }
    }
}