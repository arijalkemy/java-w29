package model;

import java.util.HashMap;
import java.util.Map;

public class RepositorioCliente {
    private Map<String, Cliente> clientes;

    public RepositorioCliente() {
        this.clientes = new HashMap<>();
    }

    public Cliente buscarCliente(String nombre) {
        return clientes.get(nombre);
    }

    public void agregarCliente(Cliente cliente) {
        clientes.put(cliente.getNombre(), cliente);
    }
}