package org.example.repository;

import org.example.clases.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ClienteImp implements CRUDInterfaz<Cliente> {
    List<Cliente> clientesCol = new ArrayList<Cliente>();

    @Override
    public void save(Cliente cliente) {
        clientesCol.add(cliente);

    }

    @Override
    public void mostrarPorPantalla() {
        System.out.println("----- Mostrar todos los clientes -----");
        for (Cliente cliente : clientesCol) {
            System.out.println(cliente.toString());
        }

    }

    @Override
    public Optional<Cliente> buscarPorDni(String dni) {
        boolean clienteEncontrado = false;
        for (Cliente cliente : clientesCol) {
            if (cliente.getDni().equals(dni)) {
                System.out.println(cliente.toString());
                clienteEncontrado = true;  // Se encontró el cliente
                return Optional.of(cliente);
            }
        }

        // Si no se encontró el cliente
        if (!clienteEncontrado) {
            System.out.println("El cliente con DNI " + dni + " no existe.");
        }

        return Optional.empty();

    }

    public Optional<Cliente> buscarPorID(Integer id) {
        boolean clienteEncontrado = false;
        for (Cliente cliente : clientesCol) {
            if (cliente.getId().equals(id)) {
                System.out.println(cliente.toString());
                clienteEncontrado = true;  // Se encontró el cliente
                return Optional.of(cliente);
            }
        }

        // Si no se encontró el cliente
        if (!clienteEncontrado) {
            System.out.println("El cliente con ID " +id + " no existe.");
        }

        return Optional.empty();

    }

    @Override
    public void eliminar(Integer id) {
        Optional<Cliente> clienteEncontrado = buscarPorID(id);
        if (clienteEncontrado.isEmpty()) {
            System.out.println("No se encontro el cliente a borrar");
        }else{
            clientesCol.remove(clienteEncontrado.get());
            System.out.println("El cliente se eliminado correctamente");
        }


    }

    @Override
    public List<Cliente> trearTodos() {
        return List.of();
    }
}
