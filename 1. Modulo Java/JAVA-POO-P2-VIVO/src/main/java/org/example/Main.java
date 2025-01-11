package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Producto[] productos = {
                new Perecedero("Leche", 10.0, 1),
                new Perecedero("Huevos", 20.0, 2),
                new NoPerecedero("Lentejas", 15.0, "Grano"),
                new NoPerecedero("Arvejas", 25.0, "Grano"),
                new Perecedero("Vacio", 30.0, 5),
        };

        double total = 0;
        int cantidadProducto = 5;

        for (Producto producto : productos) {
            total += producto.calcular(cantidadProducto);
        }

        System.out.println("Total: " + Math.round(total));

    }
}