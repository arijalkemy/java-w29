package com.thiagoschreck.local.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class GuardaRopa {
    public Map<Integer, List<Prenda>> prendas = new HashMap<>();

    public Integer guardarPrendas(List<Prenda> listaDePrendas) {
        Random random = new Random();
        while (true) {
            Integer numeroPrenda = random.nextInt(0, Integer.MAX_VALUE);
            if (!prendas.containsKey(numeroPrenda)) {
                prendas.put(numeroPrenda, listaDePrendas);
                return numeroPrenda;
            }
        }
    }

    public void mostrarPrendas() {
        System.out.println(prendas);
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return prendas.get(numero);
    }
}
