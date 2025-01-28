package com.example.services;

import com.example.entities.Cliente;
import com.example.repositories.ClienteRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public Cliente crearCliente(String nombre) {
        Cliente nuevoCliente = Cliente.builder().nombre(nombre).build();
        clienteRepository.add(nuevoCliente);
        return nuevoCliente;
    }
}
