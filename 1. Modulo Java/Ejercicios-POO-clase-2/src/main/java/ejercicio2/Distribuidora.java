package ejercicio2;

import ejercicio2.domain.NoPerecedero;
import ejercicio2.domain.Perecedero;
import ejercicio2.domain.Producto;

public class Distribuidora {
    public static void main(String[] args) {

        Producto[] productos = new Producto[5];
        productos[0] = new Perecedero("Yogurt", 10, 12);
        productos[1] = new Perecedero("Jugo", 12, 3);
        productos[2] = new Perecedero("Leche", 9, 2);
        productos[3] = new NoPerecedero("Miel", 15, "De abeja");
        productos[4] = new NoPerecedero("Arroz", 11, "Blanco");

        int precioTotal = 0;
        for (Producto producto : productos) {
            precioTotal += producto.calcular(5);
            System.out.println("Precio por 5 unidades de " + producto.getNombre() + ": " + producto.calcular(5));
        }
        System.out.println("Precio total: " + precioTotal);

    }
}
