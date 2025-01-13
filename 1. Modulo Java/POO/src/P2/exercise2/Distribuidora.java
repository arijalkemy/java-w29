package P2.exercise2;

import P2.exercise2.domain.NoPerecedero;
import P2.exercise2.domain.Perecedero;
import P2.exercise2.domain.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> listaProductos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int opt = -1;

        while(opt != 0) {
            System.out.println("Ingresa la opcion: " +
                    "⁄n 1. Agregar producto" +
                    "⁄n 2. Agregar producto perecedero" +
                    "⁄n 3. Agregar producto no perecedero" +
                    "⁄n 4. Realizar venta" +
                    "⁄n 0. Salir");
            opt = sc.nextInt();
            if (opt > 0 && opt < 4) {
                sc.nextLine();
                System.out.println("Ingrese nombre: ⁄n");
                String nombre = sc.nextLine();
                System.out.println("Ingrese precio producto ⁄n");
                double precio = sc.nextDouble();
                switch (opt) {
                    case 1 -> listaProductos.add(new Producto(nombre, precio));
                    case 2 -> {
                        System.out.println("Ingrese los dias por caducar");
                        listaProductos.add(new Perecedero(nombre, precio, sc.nextInt()));
                    }
                    case 3 -> {
                        System.out.println("Ingrese el tipo de producto");
                        listaProductos.add(new NoPerecedero(nombre, precio, sc.nextLine()));
                    }
                }
            }
            sc.nextLine();
            if (opt == 4) {
                double price = 0;
                for (Producto p : listaProductos) {
                    System.out.println("Ingrese la cantidad de productos para el producto: " + p);
                    price += p.calcular(sc.nextInt());
                    sc.nextLine();
                }
                System.out.println("El precio final de la venta es: " + price);
            }
        }
    }
}
