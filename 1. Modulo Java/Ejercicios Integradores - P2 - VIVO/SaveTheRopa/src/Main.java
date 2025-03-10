import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();
        Integer idArmario = guardaRopa.guardarPrendas(List.of(
                new Prenda("Nike", "Remera XXL"),
                new Prenda("Adidas", "Zapatillas 44"),
                new Prenda("The North Face", "Campera XXL")
        ));

        // Imprimir prendas
        guardaRopa.mostrarPrendas();

        // Obtener prendas por id e imprimir
        guardaRopa
                .devolverPrenda(idArmario)
                .forEach(System.out::println);

    }
}