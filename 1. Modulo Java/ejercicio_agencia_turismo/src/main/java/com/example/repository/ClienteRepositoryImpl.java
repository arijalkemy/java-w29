package com.example.repository;

import com.example.model.Cliente;

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
