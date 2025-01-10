import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Distribuidora {

//    private static final List<Producto> productos = List.of(
//            new NoPerecedero("Atun", 2000, "conserva"),
//            new NoPerecedero("Mani", 1000, "cereal"),
//            new Perecedero("Manzana", 500, 5),
//            new Perecedero("Pan", 600, 3),
//            new Perecedero("Carne", 12000, 1)
//    );

    private static final List<Producto> productos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa la cantidad de productos a calcular: ");
        int cantidad = scanner.nextInt();
        for (int i = 0; i < cantidad; i++) {
            System.out.print("Ingresa el tipo del producto: ");
            String tipoProducto = scanner.next();
            if (tipoProducto.equals("P")) {
                System.out.print("Ingresa el nombre: ");
                String nombre = scanner.next();
                System.out.print("Ingresa el precio: ");
                double precio = scanner.nextDouble();
                System.out.print("Ingresa los dias de caducidad: ");
                int diasCaducidad = scanner.nextInt();
                productos.add(new Perecedero(nombre, precio, diasCaducidad));
            }
            if (tipoProducto.equals("NP")) {
                System.out.print("Ingresa el nombre: ");
                String nombre = scanner.next();
                System.out.print("Ingresa el precio: ");
                double precio = scanner.nextDouble();
                System.out.print("Ingresa el tipo: ");
                String tipo = scanner.next();
                productos.add(new NoPerecedero(nombre, precio, tipo));
            }
        }

        for (Producto p: productos) {
            System.out.println("El precio de " + p.getNombre() + " es: " + p.calcular(5));
        }
    }
}
