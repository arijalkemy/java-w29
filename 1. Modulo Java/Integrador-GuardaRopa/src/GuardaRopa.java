import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private Map<Integer, List<Prenda>> prendasEnGuardaropa;
    private Integer contador;

    public GuardaRopa() {
        this.prendasEnGuardaropa = new HashMap<>();
        this.contador = 1;
    }

    public Integer guardaPrendas(List<Prenda> listaDePrendas) {
        this.prendasEnGuardaropa.put(this.contador, listaDePrendas);
        return this.contador++;
    }

    public void mostarPrendas() {
        /*prendasEnGuardaropa.entrySet().stream()
                .forEach(entry ->
                        System.out.println("Número: " + entry.getKey() + " - Prendas: " + entry.getValue())
                );*/
        prendasEnGuardaropa.forEach((id, prendas) -> {
            System.out.println("ID: " + id);
            System.out.println("Prendas:");
            prendas.forEach(prenda -> System.out.println("  - " + prenda));
        });



    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return this.prendasEnGuardaropa.get(numero);
    }

}
