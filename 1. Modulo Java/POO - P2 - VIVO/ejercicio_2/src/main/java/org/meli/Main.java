package org.meli;

import org.meli.models.NoPerecedero;
import org.meli.models.Perecedero;
import org.meli.models.Producto;

public class Main {
    public static void main(String[] args) {
        Producto[] productos = new Producto[3];
        productos[0] = new Perecedero("Leche", 2.0, 2);
        productos[1] = new NoPerecedero("Arroz", 1.5, "Alimento seco");
        productos[2] = new Perecedero("Manzana", 1.0, 1);

        double precioTotal = 0;
        for (Producto producto : productos) {
            precioTotal += producto.calcular(5);
        }

        System.out.println("Precio total al vender 5 unidades de cada producto: $" + precioTotal);

        System.out.println("\nDetalles de los productos:");
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }
}