package org.meli;

import org.meli.models.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("12345678", "Juan", "Pérez"));
        clientes.add(new Cliente("87654321", "María", "Gómez"));
        clientes.add(new Cliente("11223344", "Carlos", "López"));

        System.out.println("Clientes iniciales:");
        clientes.forEach(System.out::println);

        System.out.println("\nEliminando al cliente con DNI '87654321'...");
        clientes.removeIf(cliente -> cliente.getDni().equals("87654321"));

        System.out.println("\nClientes restantes:");
        clientes.forEach(System.out::println);

        String dniBusqueda = "12345678";
        System.out.println("\nBuscando al cliente con DNI: " + dniBusqueda);

        Optional<Cliente> clienteEncontrado = clientes.stream()
                .filter(cliente -> cliente.getDni().equals(dniBusqueda))
                .findFirst();

        if (clienteEncontrado.isPresent()) {
            System.out.println("Cliente encontrado: " + clienteEncontrado.get());
        } else {
            System.out.println("Cliente con DNI '" + dniBusqueda + "' no encontrado.");
        }
    }
}