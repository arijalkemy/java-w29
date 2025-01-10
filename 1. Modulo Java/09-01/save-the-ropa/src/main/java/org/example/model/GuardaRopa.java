package org.example.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Integer contador;
    private Map<Integer, List<Prenda>> prendas;

    public GuardaRopa() {
        this.contador = 0;
        this.prendas = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> prendas) {
        int id = contador++;
        this.prendas.put(id, prendas);
        return id;
    }

    public Map<Integer, List<Prenda>> getPrendas() {
        return prendas;
    }

    public void mostrarPrendas() {
        prendas.forEach((id, prendas) -> {
            System.out.println(id + " - " + prendas);
        });
    }

    public List<Prenda> getPrendas(Integer id) {
        return prendas.get(id);
    }
}
