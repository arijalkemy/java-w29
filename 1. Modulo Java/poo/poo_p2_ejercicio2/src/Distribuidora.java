import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {

        //array productos
        List<Productos> productos = new ArrayList<>();
        Perecederos producto1 = new Perecederos("Arroz",9.99,2);
        NoPerecederos producto2 = new NoPerecederos("Fideos",5.55,"Legumbres");
        Perecederos producto3 = new Perecederos("Pan rallado", 0.99, 5);
        NoPerecederos producto4 = new NoPerecederos("Empanadas",1.23,"Comida");
        NoPerecederos producto5 = new NoPerecederos("Harina",2.66,"CarboHidrato");

        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);

        //calcular precio total y verificar tipo de producto
        double total = 0%.2f;
        for (Productos producto:productos){
            total += producto.precio;
            if (producto.getClass().equals(NoPerecederos.class)) {
                System.out.println("No perecedero");
            }else{
                System.out.println("Perecedero");
            }

            System.out.println("Class: " + producto.getClass());
            System.out.println("Producto: " + producto);
        }
        System.out.println("El total es: " + String.format("%.2f", total));



    }
}