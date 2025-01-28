package org.example;

public class Main {
    public static void main(String[] args) {
        // Crear un arreglo de productos
        Producto[] productos = new Producto[4];

        // Inicializar productos perecederos
        productos[0] = new Perecedero("Leche", 1.5, 5, 3);
        productos[1] = new Perecedero("Yogur", 2.0, 5, 1);

        // Inicializar productos no perecederos
        productos[2] = new NoPerecedero("Arroz", 1.0, "Alimento seco");
        productos[3] = new NoPerecedero("Aceite", 3.0, "Alimento líquido");

        // Calcular el precio total al vender 5 de cada producto
        double precioTotal = 0;
        for (Producto producto : productos) {
            precioTotal += producto.calcular(5);
        }

        // Imprimir el precio total
        System.out.printf("Precio total al vender 5 productos de cada tipo: %.2f\n", precioTotal);
    }
}