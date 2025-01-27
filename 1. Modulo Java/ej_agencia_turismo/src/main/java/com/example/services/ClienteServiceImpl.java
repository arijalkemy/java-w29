package com.example.services;

import com.example.entities.Cliente;
import com.example.repositories.ClienteRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public Cliente crearCliente(String nombre) {
        int id = clienteRepository.getMaxId() + 1;
        Cliente nuevoCliente = new Cliente(id, nombre);

        clienteRepository.add(nuevoCliente);

        return nuevoCliente;
    }

}
