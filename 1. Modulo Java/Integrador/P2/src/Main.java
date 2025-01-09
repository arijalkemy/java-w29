import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();

        Prenda prenda1 = new Prenda("Nike", "Camiseta");
        Prenda prenda2 = new Prenda("Adidas", "Pantalón");
        Prenda prenda3 = new Prenda("Puma", "Zapatillas");
        Prenda prenda4 = new Prenda("Reebok", "Sudadera");

        List<Prenda> listaDePrendas1 = Arrays.asList(prenda1, prenda2);
        List<Prenda> listaDePrendas2 = Arrays.asList(prenda3, prenda4);

        Integer codigo1 = guardaRopa.guardarPrendas(listaDePrendas1);
        Integer codigo2 = guardaRopa.guardarPrendas(listaDePrendas2);

        System.out.println("Código de las prendas guardadas: " + codigo1);
        System.out.println("Código de las prendas guardadas: " + codigo2);

        guardaRopa.mostrarPrendas();

        List<Prenda> prendasRecuperadas1 = guardaRopa.devolverPrendas(codigo1);
        System.out.println("Prendas recuperadas con código " + codigo1 + ": " + prendasRecuperadas1);
        System.out.println("--------------------------------");
        guardaRopa.mostrarPrendas();
        List<Prenda> prendasRecuperadas2 = guardaRopa.devolverPrendas(codigo2);
        System.out.println("Prendas recuperadas con código " + codigo2 + ": " + prendasRecuperadas2);
    }
}