package GuardaRopa;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Crear prendas
        Prenda prenda1 = new Prenda("Nike", "Camiseta");
        Prenda prenda2 = new Prenda("Adidas", "Pantalón");

        // Crear lista de prendas y añadir las prendas creadas
        List<Prenda> listaDePrendas = new ArrayList<>();
        listaDePrendas.add(prenda1);
        listaDePrendas.add(prenda2);

        // Crear GuardaRopa y guardar las prendas
        GuardaRopa guardaRopa = new GuardaRopa();
        Integer codigo = guardaRopa.guardarPrendas(listaDePrendas);

        // Mostrar prendas almacenadas
        guardaRopa.mostrarPrendas();

        // Devolver prendas usando el código recibido
        List<Prenda> prendasRecuperadas = guardaRopa.devolverPrendas(codigo);
        System.out.println("Prendas recuperadas usando el código " + codigo + ": " + prendasRecuperadas);

        // Mostrar el estado final de los guardarropas tras la recuperación
        guardaRopa.mostrarPrendas();

    }
}