package org.example;

import java.util.*;

public class RepositorioCliente {

    private final Map<String, List<Localizador>> localizadores;

    public RepositorioCliente() {
        localizadores = new HashMap<>();
    }

    public void agregarLocalizador(Cliente cliente, Localizador localizador) {
        System.out.println("\nAgregando localizador");

        if (localizadores.containsKey(cliente.getDni())) {
            // Valida si el cliente tiene más de 2 localizadores comprados anteriormente
            localizador.calcularTotal(localizadores.get(cliente.getDni()).size() >= 2);
        } else {
            localizador.calcularTotal(false);
            localizadores.put(cliente.getDni(), new ArrayList<>());
        }
        System.out.println("Localizador agregado");

        localizadores.get(cliente.getDni()).add(localizador);
        System.out.println(localizador);
    }

}
