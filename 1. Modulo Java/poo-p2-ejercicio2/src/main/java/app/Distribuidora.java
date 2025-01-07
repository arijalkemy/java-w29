package app;

import domain.NoPerecedero;
import domain.Perecedero;
import domain.Producto;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();

        //Perecederos
        Producto perecedero1 = new Perecedero("Leche", 100.0, 2);
        Producto perecedero2 = new Perecedero("Galletas", 300.0, 1);
        Producto perecedero3 = new Perecedero("Pan", 340.0, 3);

        //No Perecederos
        Producto noperecedero1 = new NoPerecedero("Leche en polvo", 400.0, "tipo1");
        Producto noperecedero2 = new NoPerecedero("Mermelada", 500.0, "tipo2");
        Producto noperecedero3 = new NoPerecedero("Miel", 750.0, "tipo2");

        productos.add(perecedero1);
        productos.add(perecedero2);
        productos.add(perecedero3);
        productos.add(noperecedero1);
        productos.add(noperecedero2);
        productos.add(noperecedero3);

        double sumaTotal = productos
                .stream()
                .mapToDouble(producto -> producto.calcular(5))
                .sum();

        System.out.printf("Suma total: %.2f%n", sumaTotal);

    }
}
