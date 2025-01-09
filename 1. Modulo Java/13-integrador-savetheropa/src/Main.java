import savetheropa.model.Guardarropa;
import savetheropa.model.Prenda;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Guardarropa g = new Guardarropa();
        g.guardarPrenda(Arrays.asList(new Prenda("Camisa", "Dior"), new Prenda("Pantalón", "Levis")));
        g.guardarPrenda(Arrays.asList(new Prenda("Gorro", "Adidas"), new Prenda("Remera", "H&M")));

        g.mostrarPrendas();
        System.out.println("\n" + g.devolverPrendas(1));
    }
}