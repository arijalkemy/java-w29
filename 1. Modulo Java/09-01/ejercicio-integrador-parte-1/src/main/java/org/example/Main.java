package org.example;

import org.example.entity.Cliente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Cliente> clientes = new ArrayList<Cliente>(Arrays.asList(
                new Cliente("43571203", "Martín", "Pombo"),
                new Cliente("46026532", "Sofía", "Dizeo"),
                new Cliente("21980074", "Mariela", "Allegri")
        ));

        clientes.forEach(System.out::println);
        System.out.println();
        System.out.println("------- REMOVIENDO CLIENTE -------");
        clientes.removeFirst();
        clientes.forEach(System.out::println);

        System.out.println();
        System.out.println("INGRESE UN DNI A BUSCAR");
        String dni = scanner.next();
//        String dni = "21980074";
        clientes
                .stream()
                .filter((c) -> c.getDni().equals(dni))
                .findFirst()
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("El cliente no existe"));
    }
}