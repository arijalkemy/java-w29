package org.meli;

import org.meli.models.NoPerecedero;
import org.meli.models.Perecedero;
import org.meli.models.Producto;

public class Main {
    public static void main(String[] args) {
        Producto[] productos = new Producto[10];
        productos[0] = new NoPerecedero("Arroz", 200.0, "sdfsf");
        productos[1] = new Perecedero("Pollo", 400.0, 2);
        productos[2] = new NoPerecedero("Legumbres", 250.0, "dfdsf");
        productos[3] = new Perecedero("Carne", 700.0, 1);
        productos[4] = new NoPerecedero("Fideos", 300.0, "sdssdf");
        productos[5] = new Perecedero("Sushi", 1000.0, 10);
        productos[6] = new NoPerecedero("Garbanzos", 250.0, "saddf");
        productos[7] = new Perecedero("Bananas", 100.0, 30);
        productos[8] = new Perecedero("Manzanas", 200.0, 5);
        productos[9] = new NoPerecedero("Vino", 1000.0, "Bebida");

        Double resultadoTotal = 0.0;

        for (Producto producto : productos) {
            resultadoTotal += producto.calcular(5);
        }

        System.out.println("Precio total al vender 5 unidades de cada producto: $" + resultadoTotal);

        System.out.println("\nDetalles de los productos:");
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }
}
