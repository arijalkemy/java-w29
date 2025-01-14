import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        Perecedero p1 = new Perecedero("Jabon",50.0,2 );
        NoPerecedero p2 = new NoPerecedero("jamon",1200.0,"Alimento");
        productos.add(p1);
        productos.add(p2);
        double total = 0;

        for (Producto producto : productos) {
            System.out.println("Producto: " + producto.getNombre() + " Precio Unitario: "+ producto.getPrecio() + " Unidades: 5 " + "Total:" + producto.calcular(5));
            total += producto.calcular(5);
        }
        System.out.println("Total: " + total);

    }
    }

