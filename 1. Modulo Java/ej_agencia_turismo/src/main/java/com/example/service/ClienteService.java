package com.example.service;

import com.example.model.Cliente;
import com.example.repository.ClienteRepositoryImpl;

public class ClienteService {

    private final ClienteRepositoryImpl clienteRepository;

    public ClienteService() {
        this.clienteRepository = new ClienteRepositoryImpl();
    }

    public Cliente crearCliente(String nombre) {
        int id = clienteRepository.getMaxId() + 1;
        Cliente nuevoCliente = new Cliente(id, nombre);

        clienteRepository.add(nuevoCliente);

        return nuevoCliente;
    }

}
