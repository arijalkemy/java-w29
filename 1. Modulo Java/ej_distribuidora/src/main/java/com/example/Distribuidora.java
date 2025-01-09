package com.example;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();

        productos.add(new NoPerecedero("Harina", 800.0, "Alimento básico"));
        productos.add(new NoPerecedero("Detergente", 1500.0, "Limpieza"));
        productos.add(new Perecedero("Leche", 1500.0, 7));
        productos.add(new Perecedero("Carne", 5000.0, 2));
        productos.add(new Perecedero("Manzana", 200.0, 3));

        for (Producto p : productos) {
            System.out.print(p);
            System.out.println(" | Precio total (5 productos): " + p.calcular(5));
        }
    }

}
