package Servicios;

import Modelos.Cliente;

import java.util.List;
import java.util.Optional;

public class ClienteService implements IClienteService{

    private List<Cliente> clientes;

    public ClienteService(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public Cliente crearCliente(Cliente cliente) {
        clientes.add(cliente);
        return cliente;
    }

    @Override
    public Optional<Cliente> encontrarClientePordni(String dni) {
        return clientes
                .stream()
                .filter(cliente -> cliente.getDni().equals(dni))
                .findFirst();
    }

    @Override
    public boolean existeCliente(String dni) {
        return clientes
                .stream()
                .anyMatch(cliente -> cliente.getDni().equals(dni));
    }
}
