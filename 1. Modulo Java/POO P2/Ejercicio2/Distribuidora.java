package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    private List<Producto> productos;

    public Distribuidora() {
        productos = new ArrayList<>();
    }
    public Distribuidora(ArrayList<Producto> productos) {
        this.productos = productos;
    }
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }
    public double obtenerPrecioProductos() {
        double result = 0;
        for ( Producto p : productos ) {
            result += p.calcular(5);
        }
        return result;
    }
    
    public void venderProducto(Producto producto) {
        productos.remove(producto);
    }
    

}
