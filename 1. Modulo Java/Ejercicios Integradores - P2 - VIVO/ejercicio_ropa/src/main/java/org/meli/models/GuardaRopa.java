package org.meli.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> prendasMap = new HashMap<>();
    private int contador = 0;

    public Integer guardarPrendas(List<Prenda> listaDePrendas) {
        contador++;
        prendasMap.put(contador, listaDePrendas);
        return contador;
    }

    public void mostrarPrendas() {
        prendasMap.forEach((clave, prendas) -> {
            System.out.println("Número: " + clave + " -> Prendas: " + prendas);
        });
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return prendasMap.remove(numero);
    }
}