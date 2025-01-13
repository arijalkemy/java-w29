package com.example.repositories;

import com.example.entities.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepositoryImpl implements ClienteRepository {

    List<Cliente> clientes = new ArrayList<>();

    @Override
    public void add(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public int getMaxId() {
        return clientes.stream()
                .map(Cliente::getId)
                .max(Long::compare)
                .orElse(0);
    }

}
