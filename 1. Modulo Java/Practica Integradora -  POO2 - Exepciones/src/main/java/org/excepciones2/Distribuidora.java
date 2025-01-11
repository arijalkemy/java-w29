package org.excepciones2;

import org.excepciones2.model.NoPerecedero;
import org.excepciones2.model.Perecedero;
import org.excepciones2.model.Producto;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) throws Exception {

        List<Producto> productos = new ArrayList<>();

        productos.add(new Perecedero("Leche", 1.5, 5));
        productos.add(new NoPerecedero("Arroz", 2.5, "Cereal"));
        productos.add(new Perecedero("Queso", 3.0, 10));
        productos.add(new NoPerecedero("Harina", 1.0, "Panadería"));
        productos.add(new Perecedero("Carne", 12.0, 3));
        productos.add(new NoPerecedero("Atún", 4.0, "Enlatado"));
        productos.add(new Perecedero("Yogur", 0.8, 7));
        productos.add(new NoPerecedero("Aceite", 5.5, "Líquido"));
        productos.add(new Perecedero("Pescado", 10.0, 2));
        productos.add(new NoPerecedero("Lentejas", 3.2, "Legumbre"));

        double totalPrice = 0;
        int cantidadDeProductos =5;
        for (Producto p : productos){

            totalPrice += p.calcular(cantidadDeProductos);

            if (p.getClass().equals(NoPerecedero.class)) {

                System.out.println("Producto: " + p.getName() + " | " + ((NoPerecedero) p).getType() + " | No Perecedero") ;

            }else{

                System.out.println("Producto: " + p.getName() + " | " + "Vencimiento: "+ ((Perecedero) p).getDiasPorCaducar() + " | Perecedero") ;
            }

        }
        System.out.println("El total es: " + totalPrice);
    }
}