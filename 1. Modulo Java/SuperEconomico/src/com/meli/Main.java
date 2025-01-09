package com.meli;

import com.meli.model.Cliente;
import com.meli.repository.ClienteRepository;
import com.meli.repository.ClienteRepositoryImpl;

import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        ClienteRepository clienteRepository = new ClienteRepositoryImpl();

        Cliente cliente1 = new Cliente("1", "Juan", "Pedro");
        Cliente cliente2 = new Cliente("2", "Juan", "Pedro");
        Cliente cliente3 = new Cliente("3", "Juan", "Pedro");

        clienteRepository.save(cliente1);
        clienteRepository.save(cliente2);
        clienteRepository.save(cliente3);

        List<Cliente> clientes = clienteRepository.getAll();
        clientes.forEach(System.out::println);

        clienteRepository.deleteByDni("1");
        System.out.println("Despues de eliminar el cliente con dni 1");
        clientes = clienteRepository.getAll();
        clientes.forEach(System.out::println);

        Cliente cliente4 = clienteRepository.getByDni("2");
        if (!Objects.isNull(cliente4)) {
            System.out.println(cliente4);
        } else {
            System.out.println("No se ha encontrado un cliente con id especificado");
        }
    }
}
