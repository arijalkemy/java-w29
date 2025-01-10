package org.meli.services;

import org.meli.interfaces.CRUD;
import org.meli.models.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteCRUD implements CRUD<Cliente> {
    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public void create(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public Optional<Cliente> read(String id) {
        return clientes.stream().filter(cliente -> cliente.getId().equals(id)).findFirst();
    }

    @Override
    public void update(Cliente cliente) {
        delete(cliente.getId());
        create(cliente);
    }

    @Override
    public void delete(String id) {
        clientes.removeIf(cliente -> cliente.getId().equals(id));
    }
}
