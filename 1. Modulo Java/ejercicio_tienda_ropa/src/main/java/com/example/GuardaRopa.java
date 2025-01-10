package com.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private final Map<Integer, List<Prenda>> prendas;

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

        prendas.forEach((id, prendas) -> {
            System.out.print("ID: " + id);
            System.out.println(" | Prendas: " + prendas);
        });

    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return prendas.remove(numero);
    }
}
