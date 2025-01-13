package model;

import java.util.*;

public class Guardarropa {
    private int contador;
    private Map<Integer, List<Prenda>> prendas;

    public Guardarropa() {
        this.contador = 0;
        this.prendas = new HashMap<>();
    }

    public Integer guardarPrendas(Prenda ... nuevasPrendas) {
        contador += 1;
        prendas.put(contador, List.of(nuevasPrendas));
        return contador;
    }

    public void mostrarPrendas(Integer idPrendas) {
        System.out.println("IDENTIFICADOR: " + idPrendas);
        prendas.get(idPrendas).forEach(System.out::println);
    }

    public void mostrarPrendas() {
        for(Map.Entry<Integer, List<Prenda>> entrada : prendas.entrySet()) {
            mostrarPrendas(entrada.getKey());
            System.out.println();
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return prendas.get(numero);
    }
}
