package com.thiagoschreck.local;

import com.thiagoschreck.local.model.Cliente;
import com.thiagoschreck.local.model.Producto;
import com.thiagoschreck.local.repository.ClienteRepository;
import com.thiagoschreck.local.repository.FacturaRepository;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ClienteRepository clienteRepository = new ClienteRepository();
        clienteRepository.setItems(List.of(
                        new Cliente("1.234.567-8", "Johnny", "Test"),
                        new Cliente("2.234.567-8", "Johnn", "Mercadolibre"),
                        new Cliente("3.234.567-8", "Thiago", "Schreck")
                ));
        FacturaRepository facturaRepository = new FacturaRepository(clienteRepository);

        clienteRepository.getItems().forEach(System.out::println);

        System.out.println("-------");

        clienteRepository.setItems(clienteRepository.getItems().subList(0, 2));
        clienteRepository.getItems().forEach(System.out::println);

        System.out.println("-------");

        clienteRepository.getById("1.234.567-8")
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("No se ha encontrado un cliente con el DNI especificado.")
                );

        System.out.println("-------");

        clienteRepository.getById("DNI FALSO")
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("No se ha encontrado un cliente con el DNI especificado.")
                );

        System.out.println("-------");
        List<Producto> productos = List.of(
                new Producto("123", "Jabón en polvo 1kg", 1, 300),
                new Producto("323", "Queso rallado 200g", 1, 250),
                new Producto("123", "Jamón 200g", 1, 200),
                new Producto("121", "Manzana", 8, 25)
        );
        facturaRepository.crearFactura("1.234.567-8", productos);
        System.out.println(facturaRepository.getItems());
    }
}
