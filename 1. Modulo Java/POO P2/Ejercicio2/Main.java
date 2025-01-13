package Ejercicio2;

public class Main {
    public static void main(String[] args) {
        
        Perecedero p1 = new Perecedero("Manzana", 1.5, 7);
        NoPerecedero p2 = new NoPerecedero("Papaya", 2.0, "Fruta");
        Perecedero p3 = new Perecedero("Plátano", 0.8, 1);

        Distribuidora distribuidora = new Distribuidora();
        distribuidora.agregarProducto(p1);
        distribuidora.agregarProducto(p2);
        distribuidora.agregarProducto(p3);
        System.out.println(distribuidora.obtenerPrecioProductos());
        
    }
}
