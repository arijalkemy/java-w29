package org.example;

public class Distribuidora {
    //Crear una clase ejecutable llamada Distribuidora donde van a crear un array de productos,
    // imprimir el precio total al vender 5 productos de cada tipo.
    // Crear los elementos del array con los datos que quieras.

    public static void main(String[] args) {
        //crear un array de productos
        Producto[] productos = new Producto[10];

        //Crear 5 productos de cada tipo
        productos[0]= new Perecedero("Leche", 1050.00,5);
        productos[1]= new Perecedero("Queso", 2020.00,15);
        productos[2]= new Perecedero("Yogurt", 1330,2);
        productos[3]= new Perecedero("Fiambre", 2250,3);
        productos[4]= new Perecedero("Manteca", 2500,4);

        productos[5]= new NoPerecedero("Harina", 930.00,"Harinas");
        productos[6]= new NoPerecedero("Arroz", 1500.00,"Granos");
        productos[7]= new NoPerecedero("Maiz", 1300,"Granos");
        productos[8]= new NoPerecedero("Harina Integral", 1830,"Harinas");
        productos[9]= new NoPerecedero("Avena", 3400,"Harinas");

        double total =0;
        for (int i=0; i<productos.length; i++) {
            total=total+productos[i].calcular(5);
            System.out.println(productos[i].toString() + ". Precio total al vender 5 unidades: " +productos[i].calcular(5));
        }
        System.out.println("Precio total de vender 5 unidades de cada producto : " +total);


    }
}