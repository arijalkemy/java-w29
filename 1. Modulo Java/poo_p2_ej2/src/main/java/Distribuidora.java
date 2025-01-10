import java.util.List;

public class Distribuidora {

    private static final List<Producto> productos = List.of(
            new NoPerecedero("Atun", 2000, "conserva"),
            new NoPerecedero("Mani", 1000, "cereal"),
            new Perecedero("Manzana", 500, 5),
            new Perecedero("Pan", 600, 3),
            new Perecedero("Carne", 12000, 1)
    );

    public static void main(String[] args) {
        for (Producto p: productos) {
            System.out.println("El precio de " + p.getNombre() + " es: " + p.calcular(5));
        }
    }
}
