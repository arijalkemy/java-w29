package org.example;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>() {{
            // ALIMENTOS PERECEDEROS
            add(new Perecedero("Leche", 4000.00, 1));
            add(new Perecedero("Banana", 5000.00, 2));
            add(new Perecedero("Carne", 15000.00, 3));
            add(new Perecedero("Papa", 500.00, 4));
            add(new Perecedero("Pan", 2000.00, 5));

            // ALIMENTOS NO PERECEDEROS
            add(new NoPerecedero("Arroz", 2000.00, "1"));
            add(new NoPerecedero("Fideos", 10000.00, "2"));
            add(new NoPerecedero("Harina", 4000.00, "3"));
            add(new NoPerecedero("Lentejas", 5000.00, "4"));
            add(new NoPerecedero("Frijoles", 2000.00, "5"));
        }};

        double total = 0.0;
        for (Producto p : productos) {
            total += p.calcular(5);
        }
        System.out.println(total);

    }
}