package Ejercicio2_DistriProduc;

public class Distribuidora {

    public static void main(String[] args) {
        Producto[] productos = new Producto[4];

        productos[0] = new Perecedero("Leche", 1.2, 1);
        productos[1] = new Perecedero("Queso", 5.5, 3);
        productos[2] = new NoPerecedero("Arroz", 0.8, "Alimentos");
        productos[3] = new NoPerecedero("Jabón", 2.5, "Limpieza");

        int cantidadDeProductos = 5; // Número de productos de cada tipo

        for (Producto producto : productos) {
            double precioTotal = producto.calcular(cantidadDeProductos);
            System.out.println(producto + " - Precio total por " + cantidadDeProductos + " unidades: " + precioTotal);
        }
    }
}
