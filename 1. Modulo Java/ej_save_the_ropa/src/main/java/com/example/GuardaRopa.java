package com.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private Map<Integer, List<Prenda>> prendas;

    private Integer contador;

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
        System.out.println("LISTADO DE PRENDAS:");

        for (Integer key : prendas.keySet()) {
            System.out.print("ID: " + key);
            System.out.println(" | Prendas: " + prendas.get(key));
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return prendas.remove(numero);
    }
}
