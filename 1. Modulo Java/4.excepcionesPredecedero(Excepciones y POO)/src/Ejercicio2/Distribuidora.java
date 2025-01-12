package Ejercicio2;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Distribuidora {
    public static void main(String[] args) {
         ArrayList<Producto> productos = new ArrayList<>();
         Perecedero perecedero1 = new Perecedero("Celular",500,1);
         Perecedero perecedero2 = new Perecedero("Laptop",200,2);
         NoPrecedero noPrecedero = new NoPrecedero("Audifonos",100,"Accesorios");
         NoPrecedero noPrecedero1 = new NoPrecedero("Cargador",75,"Accesorios");

         productos.add(perecedero1);
         productos.add(noPrecedero1);
         productos.add(perecedero2);
         productos.add(noPrecedero1);

         double total = 0;
         for (Producto producto : productos) {
             total += producto.calcular(123);
         }
        System.out.println("El total de Los Productos es: " + total);



    }
}