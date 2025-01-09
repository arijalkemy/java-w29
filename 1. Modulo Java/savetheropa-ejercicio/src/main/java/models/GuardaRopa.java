package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Integer idContador;
    private Map<Integer, List<Prenda>> prendas;

    public GuardaRopa() {
        this.idContador = 0;
        this.prendas = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listaPrendas) {
        this.prendas.put(this.idContador, listaPrendas);
        return this.idContador++;
    }

    public void mostrarPrendas() {
        for (Map.Entry<Integer, List<Prenda>> entry : this.prendas.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
        }
    }

    public List<Prenda> devolverPrendas(Integer id) {
        return this.prendas.remove(id);
    }
}
