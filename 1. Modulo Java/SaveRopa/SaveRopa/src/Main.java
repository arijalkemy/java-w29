import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Guardaropa guardaropa = new Guardaropa();
        guardaropa.mostrarPrendas();
        List<Prenda> prendas = new ArrayList<>();
        prendas.add(new Prenda("Zara", "Camiseta"));
        prendas.add(new Prenda("Adidas", "Tennis"));

        Integer idGuardaRopa = guardaropa.guardarPrendas(prendas);
        System.out.println(guardaropa.devolverPrendas(idGuardaRopa));

        guardaropa.mostrarPrendas();
    }
}
