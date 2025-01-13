import domain.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Supermercado {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("12345678", "Juan", "Pérez"));
        clientes.add(new Cliente("23456789", "María", "García"));
        clientes.add(new Cliente("11223344", "Carlos", "López"));

        System.out.println("Lista de clientes:");
        clientes.forEach(System.out::println);

        System.out.println("\nEliminando al cliente con DNI '23456789'");
        clientes.removeIf(cliente -> cliente.getDni().equals("23456789"));

        System.out.println("\nClientes restantes:");
        clientes.forEach(System.out::println);


        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIngresar DNI del cliente que desea buscar: ");
        String dniBusqueda = scanner.nextLine();

        Optional<Cliente> clienteEncontrado = clientes.stream()
                .filter(cliente -> cliente.getDni().equals(dniBusqueda)).findFirst();

        if (clienteEncontrado.isPresent()) {
            System.out.println("\nCliente encontrado: " + clienteEncontrado.get());
        } else {
            System.out.println("\nEl cliente con DNI " + dniBusqueda + " no se encuentra en la lista.");
        }
    }
}

