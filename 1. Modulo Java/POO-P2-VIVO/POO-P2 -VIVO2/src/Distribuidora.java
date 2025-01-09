import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        Producto producto1 = new NoPerecederos("Atun", 2000, "conserva");
        Producto producto2 = new NoPerecederos("Mani", 1000, "cereal");
        Producto producto3 = new Perecederos("Manzana", 500, 5);
        Producto producto4 = new Perecederos("Pan", 600, 3);
        Producto producto5 = new Perecederos("Carne", 12000, 1);

        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);

        for (Producto p: productos){
            System.out.println("El precio de " + p.getNombre() + "es " + p.calcular(5));
        }
    }
}