package ejercicio_2;

public class Distribuidora {
    public static void main(String[] args) {

        Producto[] productos = new Producto[3];
        productos[0] = new Perecedero("Yogurt", 20.0, 2);
        productos[1] = new NoPerecedero("Duraznos", 15.0, "Lata");
        productos[2] = new Perecedero("Carne", 50.0, 1);


        Double precioTotal = 0.0;

        for (Producto producto : productos) {
            Double precioProducto = producto.calcular(5);
            System.out.println(producto + ", Precio total por 5 unidades: $" + precioProducto);
            precioTotal += precioProducto;
        }

        System.out.println("Precio total de todos los productos: " + precioTotal);
    }
}


