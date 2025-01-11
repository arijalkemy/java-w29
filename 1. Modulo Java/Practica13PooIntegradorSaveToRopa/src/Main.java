import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardarRopa guardaRopa = new GuardarRopa();
        Integer codigo = guardaRopa.guardarPrendas(List.of(
                new Prenda("Nike", "Air Max"),
                new Prenda("Adidas", "Superstar")
        ));
        System.out.println("Codigo de almacenamiento: " + codigo);
        guardaRopa.mostrarPrendas();
    }
}