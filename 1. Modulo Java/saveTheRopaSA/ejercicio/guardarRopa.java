package ejercicio;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class guardarRopa {
    private HashMap<Integer, List<Prenda>> ropa;
    private Integer idCounter;

    public guardarRopa() {
        ropa = new HashMap<>();
        idCounter = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas) {
        ropa.put(idCounter, listaDePrendas);
        return idCounter++;
    }

    public void mostrarPrendas() {
        ropa.forEach((id, lista) -> {
            System.out.println("ID " + id + ": " + lista);
        });
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return ropa.remove(numero);
    }
}