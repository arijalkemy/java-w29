import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    public static void main(String[] args) {

        List<Producto> productos = new ArrayList<>();

        Producto producto = new Perecedero("Galleta",100.0,3);
        Producto producto2 = new Perecedero("Azucar",90.0,1);
        Producto producto3 = new Perecedero("Pan",80.0,2);
        Producto producto4 = new Perecedero("Agua",70.0,1);
        Producto producto5 = new Perecedero("Gaseosa",60.0,2);
        Producto producto6 = new NoPerecedero("Sandia",300.0,"d");
        Producto producto7 = new NoPerecedero("Uva",500.0,"s");
        Producto producto8 = new NoPerecedero("Manzana",1000.0,"s");
        Producto producto9 = new NoPerecedero("Kiwi",2000.0,"f");
        Producto producto10 = new NoPerecedero("Papa",3000.0,"d");

        productos.add(producto);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);
        productos.add(producto6);
        productos.add(producto7);
        productos.add(producto8);
        productos.add(producto9);
        productos.add(producto10);
        for(int i = 0; i < productos.size(); i++){
            double p = productos.get(i).calcular(5);
            System.out.println("El precio del producto Perecedero es"+p);
        }
    }

}
