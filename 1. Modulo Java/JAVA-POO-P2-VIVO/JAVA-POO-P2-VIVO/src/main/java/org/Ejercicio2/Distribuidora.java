package org.Ejercicio2;

import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();

        Producto p1 = new Perecedero("Leche",200,2);
        Producto p2 = new NoPerecedero("Arroz",200, "Alacena");

        productos.add(p1);
        productos.add(p2);

        for(Producto p: productos) {
            System.out.println(p.getNombre());
            System.out.println(p.calcular(1));
        }
    }
}
