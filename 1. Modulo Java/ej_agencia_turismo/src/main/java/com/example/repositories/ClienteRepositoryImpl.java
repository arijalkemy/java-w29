package com.example.repositories;

import com.example.entities.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepositoryImpl implements ClienteRepository {

    List<Cliente> clientes = new ArrayList<>();

    @Override
    public void add(Cliente cliente) {
        cliente.setId(clientes.size() + 1);
        clientes.add(cliente);
    }
}
