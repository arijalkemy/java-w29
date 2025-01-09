package com.thiagoschreck.local.distribuidora;

import java.util.List;

public class Distribuidora {
    private final List<Producto> productos = List.of(
            new Perecedero("Banana", 35, 15),
            new Perecedero("Manzana", 40, 2),
            new Perecedero("Leche", 60, 1),
            new Perecedero("Carne", 130, 5),
            new Perecedero("Pollo", 280, 9),

            new NoPerecedero("Pan", 35, "No sé a qué se refiere con tipo"),
            new NoPerecedero("Nueces", 40, "No sé a qué se refiere con tipo"),
            new NoPerecedero("Fideos", 60, "No sé a qué se refiere con tipo"),
            new NoPerecedero("Arroz", 130, "No sé a qué se refiere con tipo"),
            new NoPerecedero("Lentejas", 280, "No sé a qué se refiere con tipo")
    );

    public void vender() {
        double precioTotal = productos.stream()
                .map(producto -> producto.calcular(5))
                .reduce(0.0, Double::sum);
        System.out.printf("El precio total de los productos es $%s%n", precioTotal);
    }
}
