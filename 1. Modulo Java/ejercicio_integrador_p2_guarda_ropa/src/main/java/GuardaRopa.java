import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private final Map<Integer, List<Prenda>> prendas;
    private int id;

    public GuardaRopa() {
        this.prendas = new HashMap<>();
        this.id = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        id++;
        prendas.put(id, listaDePrenda);
        return id;
    }

    public void mostrarPrendas(){
        System.out.println(prendas);
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return prendas.get(numero);
    }
}
