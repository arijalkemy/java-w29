package com.mdaneri;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Guardaropa {

    private Map<Integer, List<Prenda>> vestidorById;

    public Guardaropa() {
        vestidorById = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas) {
        Integer maxId = vestidorById.keySet().stream().max(Integer::compare).orElse(0);
        vestidorById.put(maxId + 1, listaDePrendas);
        return maxId + 1;
    }

    public void mostrarPrendas() {
        for (Integer key : vestidorById.keySet()) {
            System.out.printf("Ticket %d%n", key);
            vestidorById.get(key).forEach(prenda -> System.out.printf("\t -> %s \n", prenda));
        }
    }

    public List<Prenda> devolverPrendas(Integer id) {
        List<Prenda> prendas = vestidorById.getOrDefault(id, new ArrayList<>());
        vestidorById.remove(id);
        return prendas;
    }

}
