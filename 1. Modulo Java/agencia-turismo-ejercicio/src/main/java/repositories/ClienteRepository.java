package repositories;

import models.Cliente;

import java.util.Optional;

public interface ClienteRepository {
    Optional<Cliente> buscarPorId(Integer clienteId);
    Cliente guardar(Cliente cliente);
    Integer obtenerUltimoId();
}
