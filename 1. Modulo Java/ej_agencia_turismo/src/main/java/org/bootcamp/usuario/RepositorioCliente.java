package org.bootcamp.usuario;

import java.util.HashMap;
import java.util.Map;

public class RepositorioCliente {
    private Map<Cliente, Integer> clienteLocalizadores=new HashMap<>();




    public void agregarLocalizador(Cliente cliente, org.bootcamp.contenedores.Localizador localizador) {
        clienteLocalizadores.put(cliente, clienteLocalizadores.getOrDefault(cliente,0) + 1);
    }

    public int obtenerNumeroLocalizadores(Cliente cliente) {
        return clienteLocalizadores.getOrDefault(cliente, 0);
    }

    public boolean existeCliente(Cliente cliente) {
        return clienteLocalizadores.containsKey(cliente);
    }
}