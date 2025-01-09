import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Object> productos = List.of(new Perecedero("Perecedero 1", 100, 1), new Perecedero("Perecedero 2", 100, 2), new Perecedero("Perecedero 3", 100, 3), new NoPerecedero("NoPerecedero 1", 100, "A"), new NoPerecedero("NoPerecedero 2", 100, "B"), new NoPerecedero("NoPerecedero 3", 100, "C"));
        System.out.println(productos);


        double total = 0;
        for (Object producto : productos) {
            if (producto instanceof Perecedero){
                Perecedero perecedero = (Perecedero) producto;
                total += perecedero.calcular(5);
                imprimir(perecedero);
            }else{
                NoPerecedero noPerecedero = (NoPerecedero) producto;
                total += noPerecedero.calcular(1);
                imprimir(noPerecedero);
            }
        }
        System.out.println("Total: " + String.format("%.2f",total));
    }

    public static void imprimir(Producto producto){
        System.out.println("Venta de " + producto.getNombre() + ": " + String.format("%.2f", producto.calcular(5)));
    }
}