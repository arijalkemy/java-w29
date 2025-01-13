package com.example.demo.Exceptions;

public class Distribuidora {

    /*
    Crear una clase ejecutable llamada Distribuidora donde van a crear un array de productos,
    imprimir el precio total al vender 5 productos de cada tipo.
    Crear los elementos del array con los datos que quieras.
     */
    public static void main(String[] args) {
        Producto[] productos = new Producto[4];
        int productosAVender = 50;
        productos[0] = new Perecedero("Leche", 2.5, 1);
        productos[1] = new Perecedero("Carne", 10.0, 2);
        productos[2] = new NoPerecedero("Arroz", 1.5, "Grano");
        productos[3] = new NoPerecedero("Aceite", 5.0, "Líquido");

        double precioTotal = 0;
        for (Producto producto : productos) {
            double precio = producto.calcular(productosAVender);
            System.out.println("Producto: " + producto + ", Precio total: " + precio);
            precioTotal += precio;
        }

        System.out.println("\nPrecio total de todos los productos: " + precioTotal);
    }
}
