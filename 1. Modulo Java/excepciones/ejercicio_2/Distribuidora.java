package ejercicio_2;

public class Distribuidora {
    public static void main(String[] args) {
        Producto[] productos = new Producto[4];

        productos[0] = new Perecederos("Leche", 1.50, 3);
        productos[1] = new NoPerecederos("Arroz", 0.80, "Alimentos");
        productos[2] = new Perecederos("Carne", 5.00, 1);
        productos[3] = new NoPerecederos("Detergente", 3.00, "Limpieza");

        for (Producto producto : productos) {
            System.out.println("Producto: " + producto.nombre);
            System.out.println("Precio Total por 5 unidades: " + producto.Calcular(5));
        }
    }
}
