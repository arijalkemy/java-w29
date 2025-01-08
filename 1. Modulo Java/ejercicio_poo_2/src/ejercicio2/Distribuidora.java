package ejercicio2;

public class Distribuidora {

    public static void main(String[] args) {

        Producto[] productos = new Producto[4];
        productos[0] = new Perecedero("Leche", 50.0, 2);
        productos[1] = new Perecedero("Queso", 80.0, 1);
        productos[2] = new NoPerecedero("Arroz", 40.0, "Grano");
        productos[3] = new NoPerecedero("Aceite", 100.0, "Líquido");
        double precioTotal = 0;
        for (Producto producto : productos) {
            precioTotal += producto.calcular(5);
            System.out.println(producto);
        }
        System.out.println("Precio total al vender 5 productos de cada tipo: " + precioTotal);



    }
}
