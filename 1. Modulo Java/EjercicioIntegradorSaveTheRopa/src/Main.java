import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Prenda prenda1 = new Prenda("lala", "remera");
        Prenda prenda2 = new Prenda("Nike", "pantalon");

        List<Prenda> prendas = Arrays.asList(prenda1, prenda2);

        GuardaRopa guardaRopa = new GuardaRopa(Map.of(),1);
       int id= guardaRopa.guardarPrendas(prendas);

       guardaRopa.mostrarPrendas();

       guardaRopa.devolverPrendas(id);

    }
}