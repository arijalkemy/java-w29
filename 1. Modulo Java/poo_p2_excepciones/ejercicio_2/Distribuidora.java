package Poo.ejercicio_2;

import java.util.List;
import java.util.ArrayList;

public class Distribuidora {


    public static void main(String[] args) {

        List<Producto> productos = new ArrayList<>();


        productos.add(new Perecedero("Leche", 1.5, 1));
        productos.add(new Perecedero("Pan", 0.5, 2));
        productos.add(new Perecedero("Huevos", 3, 3));


        productos.add(new NoPerecedero("Papel Higienico", 2, "Hogar"));
        productos.add(new NoPerecedero("Lavandina", 1, "Limpieza"));
        productos.add(new NoPerecedero("Alcohol en Gel", 5, "Limpieza"));


        for (Producto producto : productos) {
            int cantidad = 5;
            System.out.println(producto + "Cantidad:" + cantidad + " - " + producto.calcular(cantidad));
        }


    }


}
