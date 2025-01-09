package com.meli.repository;

import com.meli.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteRepositoryImpl implements ClienteRepository {
    List<Cliente> clientes = new ArrayList<>();

    @Override
    public void save(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public Cliente getByDni(String dni) {
        Optional<Cliente> cliente = this.clientes.stream().filter(c -> c.getDni().equals(dni)).findFirst();
        return cliente.orElse(null);
    }

    @Override
    public void deleteByDni(String dni) {
        this.clientes.removeIf(c -> c.getDni().equals(dni));
    }

    @Override
    public List<Cliente> getAll() {
        return this.clientes;
    }
}
