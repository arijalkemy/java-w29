package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {


    public static void main(String[] args) {

        List<Producto> productos;

        productos = new ArrayList<>();


        productos.add(new Perecedero("Leche", 1.5, 1));
        productos.add(new Perecedero("Pan", 0.5, 2));
        productos.add(new Perecedero("Huevos", 3, 3));


        productos.add(new NoPerecedero("Papel Higienico", 2, "Hogar"));
        productos.add(new NoPerecedero("Lavandina", 1, "Limpieza"));
        productos.add(new NoPerecedero("Alcohol en Gel", 5, "Limpieza"));


        for (Producto producto : productos) {
            int cantidad = 5;
            // saca el indice
            System.out.println("Producto: " + productos.indexOf(producto));

            System.out.println(producto + "\n- Cantidad de producto:" + cantidad + "\n- Resultado:" + producto.calcular(cantidad));
        }


    }


}
