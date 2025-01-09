import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Distribuidora {
    public static void main(String[] args) {
        List<Productos> productos = new ArrayList<>();

        Perecederos produc = new Perecederos("Arroz",9.99,2);
        NoPerecederos produc2 = new NoPerecederos("Fideos",5.55,"Legumbres");
        Perecederos produc3 = new Perecederos("Pan rallado",0.99,5);
        NoPerecederos produc4 = new NoPerecederos("Empanadas",1.23,"Comida");
        NoPerecederos produc5 = new NoPerecederos("Harina",2.66,"CarboHidrato");

        productos.add(produc);
        productos.add(produc2);
        productos.add(produc3);
        productos.add(produc4);
        productos.add(produc5);

        double total = 0%.2f;
        for (Productos pr : productos){
            total += pr.precio;
            if (pr.getClass().equals(NoPerecederos.class)) {
                System.out.println("No perecedero");
            }else{
                System.out.println("Perecedero");
            }

            System.out.println("Class: " + pr.getClass());
            System.out.println("Producto: " + pr);
        }
        System.out.println("El total es: " + String.format("%.2f", total));



    }
}