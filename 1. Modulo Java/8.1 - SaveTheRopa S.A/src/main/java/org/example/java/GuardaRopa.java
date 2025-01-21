package org.example.java;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    Map<Integer, List<Prenda>> diccionario = new HashMap<>();;
    private Integer contador = 1;

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        diccionario.put(contador, listaDePrenda);
        contador++;

        return diccionario.size();
    }

    public void mostrarPrendas() {
        diccionario.forEach((k, v) -> System.out.println("Clave: " + k + " Valor: " + v));
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return diccionario.get(numero);
    }

    @Override
    public String toString() {
        return "GuardaRopa{" +
                "diccionario=" + diccionario +
                ", contador=" + contador +
                '}';
    }
}
