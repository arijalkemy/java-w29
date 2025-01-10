package org.example.repositorios;

import org.example.clases.Cliente;

import java.util.ArrayList;
import java.util.List;

public class Implementacionrepositorycliente implements RepositoryCliente {
    List<Cliente> clientes;

    public Implementacionrepositorycliente() {
        this.clientes = new ArrayList<>();
    }

    //busco el cliente y si no existe lo agrego
    @Override
    public Cliente buscarOAgragrCliente(Cliente cliente) {
        return clientes.stream().filter(c -> c.getId().equals(cliente.getId())).findFirst().orElseGet(() -> {
            clientes.add(cliente);
            return cliente;
        });

    }
}
