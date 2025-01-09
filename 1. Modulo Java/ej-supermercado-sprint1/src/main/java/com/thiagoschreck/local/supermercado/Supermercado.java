package com.thiagoschreck.local.supermercado;

import java.util.List;
import java.util.Optional;

public class Supermercado {
    private List<Cliente> clientes = List.of(
            new Cliente("1.234.567-8", "Johnny", "Test"),
            new Cliente("2.234.567-8", "Johnn", "Mercadolibre"),
            new Cliente("3.234.567-8", "Thiago", "Schreck")
    );

    public void listarClientes() {
        clientes.forEach(System.out::println);
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public Optional<Cliente> buscarCliente(String dni) {
        return clientes.stream()
                .filter(cliente -> cliente.getDni().equals(dni))
                .findFirst();
    }

}
