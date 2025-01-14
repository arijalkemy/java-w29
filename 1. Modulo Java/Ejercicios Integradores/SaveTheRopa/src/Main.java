import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Guardarropas guardarropas = new Guardarropas();

        // Creación de prendas
        List<Prenda> listaDePrendas = new ArrayList<>();
        listaDePrendas.add(new Prenda( "Nike", "Dri-FIT"));
        listaDePrendas.add(new Prenda( "Adidas", "Stan Smith"));

        // Guardar prendas
        Integer codigo = guardarropas.guardarPrendas(listaDePrendas);
        System.out.println("Prendas guardadas bajo el código: " + codigo);

        // Mostrar todas las prendas en el guardarropas
        guardarropas.mostrarPrendas();

        // Recuperar prendas con el código
        List<Prenda> prendasRecuperadas = guardarropas.devolverPrendas(codigo);
        System.out.println("Prendas recuperadas para el código " + codigo + ": " + prendasRecuperadas);
    }
}