package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Perecedero pe = new Perecedero("Yogurt", 10.0, 2);
        NoPerecedero noPe = new NoPerecedero("Lenteja", 5.0, "Legumbre");
        List<Producto> productos = new ArrayList<>();
        productos.add(pe);
        productos.add(noPe);
        Distribuidora d = new Distribuidora(productos);

        System.out.println("Precio final: " + d.imprimirPrecio(5));
    }
}