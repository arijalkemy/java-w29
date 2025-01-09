
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> prendas;
    private int contador;

    public GuardaRopa() {
        this.prendas = new HashMap<>();
        this.contador = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        contador++;
        prendas.put(contador, listaDePrenda);
        return contador;
    }

    public void mostrarPrendas() {
        for (Map.Entry<Integer, List<Prenda>> entry : prendas.entrySet()) {
            System.out.println("Número: " + entry.getKey() + " - Prendas: " + entry.getValue());
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return prendas.remove(numero);
    }
}