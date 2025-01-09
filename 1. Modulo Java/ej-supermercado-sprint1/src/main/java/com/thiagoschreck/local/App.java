package com.thiagoschreck.local;

import com.thiagoschreck.local.supermercado.Supermercado;

public class App {
    public static void main(String[] args) {
        Supermercado supermercado = new Supermercado();
        supermercado.listarClientes();

        System.out.println("-------");

        supermercado.setClientes(supermercado.getClientes().subList(0, 2));
        supermercado.listarClientes();

        System.out.println("-------");

        supermercado.buscarCliente("1.234.567-8")
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("No se ha encontrado un cliente con el DNI especificado.")
                );

        System.out.println("-------");

        supermercado.buscarCliente("DNI FALSO")
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("No se ha encontrado un cliente con el DNI especificado.")
                );
    }
}
