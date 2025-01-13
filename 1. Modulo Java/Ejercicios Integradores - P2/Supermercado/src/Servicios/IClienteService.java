package Servicios;

import Modelos.Cliente;

import java.util.Optional;

public interface IClienteService {

    Cliente crearCliente(Cliente cliente);
    Optional<Cliente> encontrarClientePordni(String dni);
    boolean existeCliente(String dni);
}
