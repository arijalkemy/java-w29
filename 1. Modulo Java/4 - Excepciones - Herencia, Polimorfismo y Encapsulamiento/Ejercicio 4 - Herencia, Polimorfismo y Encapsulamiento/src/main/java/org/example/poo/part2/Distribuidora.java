package org.example.poo.part2;

public class Distribuidora {
    public static void main(String[] args) {
        Producto[] productos = new Producto[5];
        productos[0] = new NoPerecedero("No perecedero 1", 110.0, "Tipo 1");
        productos[1] = new NoPerecedero("No perecedero 2", 10.0, "Tipo 2");
        productos[2] = new NoPerecedero("No perecedero 13", 530.0, "Tipo 2");
        productos[3] = new NoPerecedero("No perecedero 15", 520.0, "Tipo 3");
        productos[4] = new NoPerecedero("No perecedero 16", 160.0, "Tipo 1");

        double precioTotal = 0;
        for (Producto producto : productos) {
            precioTotal += producto.calcular(5);
        }

        System.out.println("El precio total al vender 5 productos de cada tipo es: " + precioTotal);
    }
}
