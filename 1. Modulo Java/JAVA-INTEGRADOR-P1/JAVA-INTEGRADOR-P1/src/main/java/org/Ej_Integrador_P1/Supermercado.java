package org.Ej_Integrador_P1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Supermercado {
    public static void main(String[] args) {
        // Crear una colección para almacenar clientes
        List<Cliente> clientes = new ArrayList<>();

        // Crear 3 clientes y agregarlos a la colección
        clientes.add(new Cliente("12345678", "Juan", "Pérez"));
        clientes.add(new Cliente("87654321", "Ana", "García"));
        clientes.add(new Cliente("11223344", "Carlos", "López"));

        // Mostrar datos de todos los clientes
        System.out.println("Clientes registrados:");
        clientes.forEach(System.out::println);

        // Eliminar un cliente de la lista
        System.out.println("\nEliminando al cliente con DNI 87654321...");
        clientes.removeIf(cliente -> cliente.getDni().equals("87654321"));

        // Mostrar los clientes restantes
        System.out.println("Clientes restantes:");
        clientes.forEach(System.out::println);

        // Solicitar por teclado un número de DNI para buscar un cliente
        System.out.print("Ingrese el DNI del cliente a buscar: ");
        Scanner scanner = new Scanner(System.in);

        String dniBuscado = scanner.nextLine();

        Cliente clienteEncontrado = clientes.stream()
                .filter(cliente -> cliente.getDni().equals(dniBuscado))
                .findFirst()
                .orElse(null);

        if (clienteEncontrado != null) {
            System.out.println("Cliente encontrado: " + clienteEncontrado);
        } else {
            System.out.println("El cliente con DNI " + dniBuscado + " no se encuentra en la lista.");
        }

        scanner.close();
    }
}
