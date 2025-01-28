package org.example;

public class Distribuidora {
    public static void main(String[] args) {

        Producto[] productos = new Producto[4];


        productos[0] = new Perecedero("Leche", 1.5, 5, 3);
        productos[1] = new Perecedero("Yogur", 2.0, 5, 1);
        productos[2] = new NoPerecedero("Arroz", 1.0, "Alimento seco");
        productos[3] = new NoPerecedero("Aceite", 3.0, "Alimento líquido");


        double precioTotal = 0;
        for (Producto producto : productos) {
            precioTotal += producto.calcular(5);
        }


        System.out.printf("Precio total al vender 5 productos de cada tipo: %.2f\n", precioTotal);
    }
}
