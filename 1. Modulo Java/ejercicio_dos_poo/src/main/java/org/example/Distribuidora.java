package org.example;

public class Distribuidora {
    public static void main(String[] args) {
        // Crear el array de productos
        Producto[] productos = new Producto[10];

        // Crear 5 productos perecederos
        productos[0] = new Perecedero("Leche", 1.8, 1);
        productos[1] = new Perecedero("Yogurt", 1.2, 2);
        productos[2] = new Perecedero("Pan", 0.8, 3);
        productos[3] = new Perecedero("Tomates", 2.3, 1);
        productos[4] = new Perecedero("Queso", 4.0, 2);

        // Crear 5 productos no perecederos
        productos[5] = new NoPerecedero("Arroz", 1.5, "Grano");
        productos[6] = new NoPerecedero("Harina", 2.0, "Grano");
        productos[7] = new NoPerecedero("Aceite", 7.5, "Líquido");
        productos[8] = new NoPerecedero("Sal", 0.8, "Condimento");
        productos[9] = new NoPerecedero("Azúcar", 3.8, "Grano");

        // Vender 5 productos de cada tipo
        double totalPerecederos = 0;
        double totalNoPerecederos = 0;

        // Calcular el precio total de los productos perecederos
        for (int i = 0; i < 5; i++) {
            totalPerecederos += productos[i].calcular(5);
        }

        // Calcular el precio total de los productos no perecederos
        for (int i = 5; i < 10; i++) {
            totalNoPerecederos += productos[i].calcular(5);
        }

        // Mostrar los resultados
        System.out.println("Total por la venta de productos perecederos: " + totalPerecederos);
        System.out.println("Total por la venta de productos no perecederos: " + totalNoPerecederos);
        System.out.println("Total general: " + (totalPerecederos + totalNoPerecederos));
    }
}

