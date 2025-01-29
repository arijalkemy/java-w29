import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Guardaropa {
    Map<Integer, List<Prenda>> prendas;

    public Guardaropa() {
        this.prendas = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> prendas) {
        Integer id = prendas.size() + 1;
        this.prendas.put(id, prendas);
        return id;
    }

    public void mostrarPrendas() {
        prendas.forEach((id, prenda)  -> {
            System.out.println(id + ": " + prenda);
        });
    }

    public List<Prenda> devolverPrendas(Integer id) {
        return prendas.get(id);
    }

}
