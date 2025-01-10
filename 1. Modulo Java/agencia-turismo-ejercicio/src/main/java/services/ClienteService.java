package services;

import models.Cliente;
import repositories.ClienteRepository;

public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente crearCliente(String nombre) {
        Integer id = this.clienteRepository.obtenerUltimoId();
        Cliente nuevoCliente = new Cliente(id, nombre);
        clienteRepository.guardar(nuevoCliente);
        return nuevoCliente;
    }

    public Cliente obtenerCliente(Cliente cliente) {
        if (cliente == null) throw new IllegalArgumentException("El cliente no puede ser nulo");
        return this.clienteRepository.buscarPorId(cliente.getId())
                .orElseGet( () -> this.crearCliente(cliente.getNombre()));
    }

}
