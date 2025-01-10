package repositories;

import models.Cliente;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ClienteRepositoryImpl implements ClienteRepository {

    private final Map<Integer, Cliente> clientes = new HashMap<>();

    @Override
    public Optional<Cliente> buscarPorId(Integer clienteId) {
        return Optional.ofNullable(clientes.get(clienteId));
    }

    @Override
    public Cliente guardar(Cliente cliente) {
        clientes.put(cliente.getId(), cliente);
        return cliente;
    }

    @Override
    public Integer obtenerUltimoId() {
        return clientes.size() + 1;
    }
}
