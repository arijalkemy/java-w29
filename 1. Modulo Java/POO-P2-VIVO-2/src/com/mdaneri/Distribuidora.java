package com.mdaneri;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {

        List<Producto> productos = new ArrayList<>();
        productos.add(new NoPerecedero("Arvejas", 10, "Comida"));
        productos.add(new NoPerecedero("Milanesa", 2, "Comida"));
        productos.add(new Pedecedero("Manzana", 20, 10));
        productos.add(new Pedecedero("Pera", 20, 1));
        productos.add(new Pedecedero("Maiz", 15, 2));

        double aPagar = 0;
        for (Producto p : productos) {
            aPagar += p.calcular(1);
        }
        System.out.println("$" + aPagar);

    }
}